/*-
 * See the file LICENSE for redistribution information.
 * 
 * Copyright (c) 2010, 2019 Oracle and/or its affiliates.  All rights reserved.
 *
 */

package repmgrtests;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

/**
 * Test of Replication Manager's ability to discriminate between
 * per-connection wire protocol versions.  When configured to use
 * heartbeats, a modern repmgr nevertheless should ignore them when
 * talking to a v1 connection.
 */
// TODO: it might make more sense to refer to sites with a name, which
// could double as the env directory name.
// 
public class TestMixedHeartbeats extends AbstractUpgTest {

    public interface Ops {
        public void setConfig(Config c);
        public void joinExistingClient(int site, boolean useHB)
            throws Exception;
        public void becomeMaster(int site) throws Exception;
        public MyStats getStats(int site) throws Exception;
        public void checkMinVersion() throws Exception;
        public void checkpoint(int site) throws Exception;
    }

    public interface Ops46 {
        public void setConfig(Config c);
        public void createMaster(int site, boolean configureClient)
            throws Exception;
        public void establishClient(int site, boolean configureMaster)
            throws Exception;
        public void shutDown(int siteId) throws Exception;
        public void remove(int site) throws Exception;
        public void checkMaxVersion() throws Exception;
    }


    public TestMixedHeartbeats() {
        super("46", "repmgrtests.V46impl", "repmgrtests.CurrentImpl");
    }

    @Test public void upg() throws Exception {
        Ops46 oldGroup = (Ops46)oldGroup_o;
        Ops currentGroup = (Ops)currentGroup_o;

        // also: ask DB its version, and make sure it's what we expect
        // (or at least in reasonable range),
        // otherwise we have no business running this test.

        // create a v1 master, maybe add some data
        // create a v2 client to join (configured for hb), wait for start-up done
        // maybe write some new txns at master, see that they get to client
        // pause for hb monitor time expiration
        // verify that no election has been called (check election stats at each site, I guess)
        // shut down v1 master
        // verify that client site takes over (use nsites == 2, and don't disable kluge)
        // upgrade site 1, and have it rejoin as a client
        // pause again, verify no add'l election (not counting the one take-over we know about)
        // (maybe we don't need fiddler, since we've already tested normal v2 hb operation)
        //
        // V1 operations:
        //    create master
        //    write some txns
        //    read some stats
        //    shut down, recover, remove (for upgrade)
        // v2 operations:
        //    join a group, wait for start-up done
        //    read some stats
        //    run a checkpoint
        //
        // version-independent configuration:
        //    master port 6000
        //    client port 6001
        //    base directory (site directories to be generated by some simple rule?)

        File testdir = new File("TESTDIR");
        Util.rm_rf(testdir);
        testdir.mkdir();
        Config config = new Config(testdir);
        oldGroup.setConfig(config);
        currentGroup.setConfig(config);

        oldGroup.createMaster(0, false);
        oldGroup.establishClient(1, true);

        currentGroup.joinExistingClient(1, true);

        // Even though the v1 site clearly cannot be sending heartbeats,
        // the v2 site should be smart enough not to consider that an
        // error, even though it is configured for heartbeats.
        // 
        MyStats s1 = currentGroup.getStats(1);
        long initialCount = s1.elections;
        long initialEgen = s1.egen;
        Thread.sleep(10000);
        s1 = currentGroup.getStats(1);
        assertEquals(initialCount, s1.elections);
        assertEquals(initialEgen, s1.egen);

        // Shut down master, verify that client takes over.
        //
        oldGroup.shutDown(0);
        currentGroup.becomeMaster(1);
        s1 = currentGroup.getStats(1);
        assertEquals(initialCount+1, s1.elections);
        assertTrue("Site 1 is now master", s1.envId == s1.master);
        
        // Upgrade the former master (site 0), and rejoin the group.
        // NB: IINM, this form of upgrade works when the log formats may have
        // changed, but database formats have not.  I guess if a
        // future release changes database formats, we'll have to go
        // through a bit more work to do this upgrade in the test here.
        // 
        oldGroup.remove(0);
        currentGroup.checkpoint(0);
        currentGroup.joinExistingClient(0, true);

        // Now site 1 is master, and site 0 has rejoined as a client, both running
        // 4.7 (or higher).  Pause again; heartbeats should be flowing, and there
        // should be no interruption for elections.
        //
        MyStats s0 = currentGroup.getStats(0);
        assertTrue(s0.envId != s0.master);
        s1 = currentGroup.getStats(1);
        assertTrue(s1.envId == s1.master);
        initialCount = s0.elections;
        initialEgen = s0.egen;
        Thread.sleep(10000);
        s0 = currentGroup.getStats(0);
        assertEquals(initialCount, s0.elections);
        assertEquals(initialEgen, s0.egen);
    }

    // TODO: during mixed mode, write some txns at master to verify that
    // acks can be transmitted correctly.  (Shall we check that the master
    // really does recognize that it has a site connected?)
}
