#!/bin/bash

dir=`dirname "$0"`

export PANDA_PAGERANK_ALPHA="0.001"
ent -cp $dir/../classes:../lib/collections-generic-4.01.jar:$dir/../lib/colt-1.2.0.jar:$dir/../lib/dsiutils-2.2.4.jar:$dir/../lib/fastutil-7.0.8.jar:$dir/../lib/webgraph-3.5.0.jar:$dir/../lib/slf4j-api-1.7.10.jar:$dir/../lib/jsap-2.1.jar:$dir/../lib/sux4j-3.2.2.jar util.PageRankBench ../graph/frwiki-2013
mv mode.txt run_ld_hc${1}.txt
