// Copyright (c) 2014-2018 The BlackCoin Developers
// Copyright (c) 2011-2013 The PPCoin developers
// Distributed under the MIT software license, see the accompanying
// file COPYING or http://www.opensource.org/licenses/mit-license.php.

// Stake cache by Qtum
// Copyright (c) 2016-2018 The Qtum developers

#include "pos.h"

#include "chain.h"
#include "chainparams.h"
#include "clientversion.h"
#include "coins.h"
#include "hash.h"
#include "main.h"
#include "uint256.h"
#include "primitives/transaction.h"
#include <stdio.h>
#include "util.h"

// Stake Modifier (hash modifier of proof-of-stake):
// The purpose of stake modifier is to prevent a txout (coin) owner from
// computing future proof-of-stake generated by this txout at the time
// of transaction confirmation. To meet kernel protocol, the txout
// must hash with a future stake modifier to generate the proof.
uint256 ComputeStakeModifier(const CBlockIndex* pindexPrev, const uint256& kernel)
{
    if (!pindexPrev)
        return uint256(); // genesis block's modifier is 0

    CHashWriter ss(SER_GETHASH, 0);
    ss << kernel << pindexPrev->nStakeModifier;
    return ss.GetHash();
}

// Check whether the coinstake timestamp meets protocol
bool CheckCoinStakeTimestamp(int64_t nTimeBlock, int64_t nTimeTx)
{
    const Consensus::Params& params = Params().GetConsensus();
    if (params.IsProtocolV2(nTimeBlock))
        return (nTimeBlock == nTimeTx) && ((nTimeTx & params.nStakeTimestampMask) == 0);
    else
        return (nTimeBlock == nTimeTx);
}

// Simplified version of CheckCoinStakeTimestamp() to check header-only timestamp
bool CheckStakeBlockTimestamp(int64_t nTimeBlock)
{
   return CheckCoinStakeTimestamp(nTimeBlock, nTimeBlock);
}

// BlackCoin kernel protocol v3
// coinstake must meet hash target according to the protocol:
// kernel (input 0) must meet the formula
//     hash(nStakeModifier + txPrev.nTime + txPrev.vout.hash + txPrev.vout.n + nTime) < bnTarget * nWeight
// this ensures that the chance of getting a coinstake is proportional to the
// amount of coins one owns.
// The reason this hash is chosen is the following:
//   nStakeModifier: scrambles computation to make it very difficult to precompute
//                   future proof-of-stake
//   txPrev.nTime: slightly scrambles computation
//   txPrev.vout.hash: hash of txPrev, to reduce the chance of nodes
//                     generating coinstake at the same time
//   txPrev.vout.n: output number of txPrev, to reduce the chance of nodes
//                  generating coinstake at the same time
//   nTime: current timestamp
//   block/tx hash should not be used here as they can be generated in vast
//   quantities so as to generate blocks faster, degrading the system back into
//   a proof-of-work situation.
//
bool CheckStakeKernelHash(const CBlockIndex* pindexPrev, unsigned int nBits, uint32_t blockFromTime, CAmount prevoutValue, const COutPoint& prevout, unsigned int nTimeTx, bool fPrintProofOfStake)
{
    if (nTimeTx < blockFromTime)  // Transaction timestamp violation
        return error("CheckStakeKernelHash() : nTime violation");

    // Base target
    arith_uint256 bnTarget;
    bnTarget.SetCompact(nBits);

    // Weighted target
    int64_t nValueIn = prevoutValue;
    if (nValueIn == 0)
        return error("CheckStakeKernelHash() : nValueIn = 0");
    arith_uint256 bnWeight = arith_uint256(nValueIn);
    bnTarget *= bnWeight;

    uint256 nStakeModifier = pindexPrev->nStakeModifier;

    // Calculate hash
    CHashWriter ss(SER_GETHASH, 0);
    ss << nStakeModifier;
    ss << blockFromTime << prevout.hash << prevout.n << nTimeTx;

    uint256 hashProofOfStake = ss.GetHash();

    if (fPrintProofOfStake)
    {
        LogPrintf("CheckStakeKernelHash() : nStakeModifier=%s, txPrev.nTime=%u, txPrev.vout.hash=%s, txPrev.vout.n=%u, nTimeTx=%u, hashProof=%s\n",
            nStakeModifier.GetHex().c_str(),
            blockFromTime, prevout.hash.ToString(), prevout.n, nTimeTx,
            hashProofOfStake.ToString());
    }

    // Now check if proof-of-stake hash meets target protocol
    if (UintToArith256(hashProofOfStake) > bnTarget)
        return false;

    if (fDebug && !fPrintProofOfStake)
    {
        LogPrintf("CheckStakeKernelHash() : nStakeModifier=%s, txPrev.nTime=%u, txPrev.vout.hash=%s, txPrev.vout.n=%u, nTimeTx=%u, hashProof=%s\n",
            nStakeModifier.GetHex().c_str(),
            blockFromTime, prevout.hash.ToString(), prevout.n, nTimeTx,
            hashProofOfStake.ToString());
    }

    return true;
}

// Check kernel hash target and coinstake signature
bool CheckProofOfStake(CBlockIndex* pindexPrev, const CTransaction& tx, unsigned int nBits, CValidationState& state, unsigned int nTimeTx)
{
    if (!tx.IsCoinStake())
        return error("CheckProofOfStake() : called on non-coinstake %s", tx.GetHash().ToString());

    // Kernel (input 0) must match the stake hash target per coin age (nBits)
    const CTxIn& txin = tx.vin[0];

    // First try finding the previous transaction in database
    CTransaction txPrev;
    uint256 hashBlock = uint256();
    if (!GetTransaction(txin.prevout.hash, txPrev, Params().GetConsensus(), hashBlock, true))
       return state.DoS(100, error("CheckProofOfStake() : INFO: read txPrev failed"));  // previous transaction not in main chain, may occur during initial download

    if (mapBlockIndex.count(hashBlock) == 0)
        return fDebug ? state.DoS(100, error("CheckProofOfStake() : read block failed")) : false; // unable to read block of previous transaction

    // Verify inputs
    if (txin.prevout.hash != txPrev.GetHash())
        return state.DoS(100, error("CheckProofOfStake() : coinstake input does not match previous output %s", txin.prevout.hash.GetHex()));

    // Verify signature
    if (!VerifySignature(txPrev, tx, 0, SCRIPT_VERIFY_NONE, 0))
       return state.DoS(100, error("CheckProofOfStake() : VerifySignature failed on coinstake %s", tx.GetHash().ToString()));

    // Min age requirement
    CBlockIndex* pblockindex = mapBlockIndex[hashBlock];
    if (pindexPrev->nHeight + 1 - pblockindex->nHeight < Params().GetConsensus().nCoinbaseMaturity){
        return state.DoS(100, error("CheckProofOfStake() : stake prevout is not mature, expecting %i and only matured to %i", Params().GetConsensus().nCoinbaseMaturity, pindexPrev->nHeight + 1 - mapBlockIndex[hashBlock]->nHeight));
    }

    if (!CheckStakeKernelHash(pindexPrev, nBits, (txPrev->nTime ? txPrev->nTime : pblockindex.GetBlockTime()), txPrev->vout[prevout.n].nValue, txin.prevout, nTimeTx, fDebug))
       return state.DoS(1, error("CheckProofOfStake() : INFO: check kernel failed on coinstake %s", tx.GetHash().ToString())); // may occur during initial download or if behind on block chain sync

    return true;
}

bool VerifySignature(const CTransaction& txFrom, const CTransaction& txTo, unsigned int nIn, unsigned int flags, int nHashType)
{
    assert(nIn < txTo.vin.size());
    const CTxIn& txin = txTo.vin[nIn];
    if (txin.prevout.n >= txFrom.vout.size())
        return false;
    const CTxOut& txout = txFrom.vout[txin.prevout.n];

    if (txin.prevout.hash != txFrom.GetHash())
        return false;

    return VerifyScript(txin.scriptSig, txout.scriptPubKey, flags, TransactionSignatureChecker(&txTo, nIn, 0),  NULL);
}

bool CheckKernel(CBlockIndex* pindexPrev, unsigned int nBits, uint32_t nTimeBlock, const COutPoint& prevout){
    std::map<COutPoint, CStakeCache> tmp;
    return CheckKernel(pindexPrev, nBits, nTimeBlock, prevout, tmp);
}

bool CheckKernel(CBlockIndex* pindexPrev, unsigned int nBits, uint32_t nTime, const COutPoint& prevout, const std::map<COutPoint, CStakeCache>& cache)
{
    auto it = cache.find(prevout);
    if (it == cache.end()) {
        CTransaction txPrev;
        uint256 hashBlock = uint256();
        if (!GetTransaction(prevout.hash, txPrev, Params().GetConsensus(), hashBlock, true)){
            LogPrintf("CheckKernel() : could not find previous transaction %s\n", prevout.hash.ToString());
            return false;
        }

        if (mapBlockIndex.count(hashBlock) == 0) {
            LogPrintf("CheckKernel() : could not find block of previous transaction %s\n", hashBlock.ToString());
            return false;
        }

        CBlockIndex* pblockindex = mapBlockIndex[hashBlock];
        if (pindexPrev->nHeight + 1 - pblockindex->nHeight < Params().GetConsensus().nCoinbaseMaturity){
            LogPrintf("CheckKernel() : stake prevout is not mature in block %s\n", hashBlock.ToString());
            return false;
        }

        return CheckStakeKernelHash(pindexPrev, nBits, (txPrev->nTime ? txPrev->nTime : pblockindex.GetBlockTime()), txPrev->vout[prevout.n].nValue, prevout, nTime);
    } else {
        //found in cache
        const CStakeCache& stake = it->second;
        /*
        // Blackcoin ToDo: check and enable this!
        if (CheckStakeKernelHash(pindexPrev, nBits, stake.blockFromTime, stake.amount, prevout, nTime)) {
            // Cache could potentially cause false positive stakes in the event of deep reorgs, so check without cache also
            return CheckKernel(pindexPrev, nBits, nTime, prevout);
        }
        */
        return CheckStakeKernelHash(pindexPrev, nBits, stake.blockFromTime, stake.amount, prevout, nTime);
    }
}

void CacheKernel(std::map<COutPoint, CStakeCache>& cache, const COutPoint& prevout, CBlockIndex* pindexPrev){
    if (cache.find(prevout) != cache.end()) {
        //already in cache
        return;
    }
    CTransaction txPrev;
    uint256 hashBlock = uint256();
    if (!GetTransaction(prevout.hash, txPrev, Params().GetConsensus(), hashBlock, true)){
        LogPrintf("CacheKernel() : could not find previous transaction %s\n", prevout.hash.ToString());
        return;
    }

    if (mapBlockIndex.count(hashBlock) == 0) {
        LogPrintf("CacheKernel() : could not find block of previous transaction %s\n", hashBlock.ToString());
        return;
    }

    CBlockIndex* pblockindex = mapBlockIndex[hashBlock];
    if (pindexPrev->nHeight + 1 - pblockindex->nHeight < Params().GetConsensus().nCoinbaseMaturity){
        LogPrintf("CheckKernel() : stake prevout is not mature in block %s\n", hashBlock.ToString());
        return;
    }

    CStakeCache c((txPrev->nTime ? txPrev->nTime : pblockindex->GetBlockTime()), txPrev->vout[prevout.n].nValue);
    cache.insert({prevout, c});
}
