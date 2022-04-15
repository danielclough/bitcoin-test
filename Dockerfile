FROM ubuntu
ARG TZ=America/Los_Angeles
ARG DEBIAN_FRONTEND=noninteractive
RUN ln -snf /usr/share/zoneinfo/${TZ} /etc/localtime && echo ${TZ} > /etc/timezone && \
      apt-get update && apt-get install -yqq  --no-install-recommends \
                      apt-utils \
                          wget \
                          jq \
                          bc \
                          vim \
                          git \
                          make \
                          file \
                          autoconf \
                          automake \
                          libtool \
                          libevent-dev \
                          build-essential \
                          autotools-dev \
                          pkg-config \
                          bsdmainutils \
                          python3 \
                          libevent-dev \
                          libboost-all-dev \
                          libminiupnpc-dev \
                          libzmq3-dev \
                          libssl-dev \
                          gperf 
#
# Build Blackcoin More
#
COPY . ./
RUN (ls -al && tar -xvf /depends/db-6.2.38.tar.gz && \
      cd /depends/db-6.2.38/build_unix && \
      mkdir -p build && \
      BDB_PREFIX=$(pwd)/build && \
      ../dist/configure --disable-shared  -disable-replication --enable-cxx --with-pic  --prefix=${BDB_PREFIX} --with-gui=no --enable-glibc-back-compat --enable-reduce-exports --disable-tests --disable-bench --disable-gui-tests --disable-man && \
      make install && \
      cd ../.. && \
      cd /  && ./autogen.sh && \
      ./configure CPPFLAGS="-I${BDB_PREFIX}/include/ -O2" LDFLAGS="-L${BDB_PREFIX}/lib/" --disable-tests --disable-bench --enable-reduce-exports && \
      make -j4 && \
      cd src/ && \
      strip blackmore*) && \
#
# Build btcdeb
#
  cd / && \
  git clone https://github.com/bitcoin-core/btcdeb.git && \
  cd btcdeb && \
  ./autogen.sh && \
  ./configure && \
  make && \
  strip btcc && \
#
# Prepare entrypoint
#
  cp /contrib/docker/action-entry.sh /usr/local/bin/ && \
  chmod u+x /usr/local/bin/action-entry.sh && \
#
# Prepare for minimal package
#
  cp /contrib/docker/action-entry.sh /usr/local/bin/ && \
  chmod u+x /usr/local/bin/action-entry.sh && \
  cp /src/blackmored /usr/local/bin/ && \
  cp /src/blackmore-cli /usr/local/bin/ && \
  cp /btcdeb/btcc /usr/local/bin/ && \
  mkdir /parts  && \
  cd  /parts  && \
  cp --parents /usr/local/bin/blackmored ./ && \
  for i in `ldd /usr/local/bin/blackmored | grep -v linux-vdso.so.1 | awk {' if ( $3 == "") print $1; else print $3 '}`; do cp --parents ${i} ./; done && \
  cp --parents /usr/local/bin/blackmore-cli ./ && \
  for i in `ldd /usr/local/bin/blackmore-cli | grep -v linux-vdso.so.1 | awk {' if ( $3 == "") print $1; else print $3 '}`; do cp --parents ${i} ./; done && \
  cp --parents /usr/local/bin/btcc ./ && \
  for i in `ldd /usr/local/bin/btcc | grep -v linux-vdso.so.1 | awk {' if ( $3 == "") print $1; else print $3 '}`; do cp --parents ${i} ./; done && \
  cp /usr/bin/bc --parents ./ && \
  for i in `ldd /usr/bin/bc | grep -v linux-vdso.so.1 | awk {' if ( $3 == "") print $1; else print $3 '}`; do cp --parents ${i} ./; done && \
  cp /usr/bin/vim --parents ./ && \
  for i in `ldd /usr/bin/vim | grep -v linux-vdso.so.1 | awk {' if ( $3 == "") print $1; else print $3 '}`; do cp --parents ${i} ./; done && \
  cp /usr/bin/jq --parents ./ && \
  for i in `ldd /usr/bin/jq | grep -v linux-vdso.so.1 | grep -v libjq.so.1 | awk {' if ( $3 == "") print $1; else print $3 '}`; do cp --parents ${i} ./; done && \
  cp /bin/echo --parents ./ && \
  for i in `ldd /bin/echo | grep -v linux-vdso.so.1 | grep -v libjq.so.1 | awk {' if ( $3 == "") print $1; else print $3 '}`; do cp --parents ${i} ./; done

ENTRYPOINT ["action-entry.sh"]