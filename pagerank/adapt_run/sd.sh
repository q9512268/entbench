#!/bin/bash

ent -cp ../classes:../lib/collections-generic-4.01.jar:../lib/colt-1.2.0.jar:../lib/dsiutils-2.2.4.jar:../lib/fastutil-7.0.8.jar:../lib/webgraph-3.5.0.jar:../lib/slf4j-api-1.7.10.jar:../lib/jsap-2.1.jar:../lib/sux4j-3.2.2.jar util.PageRankBench ../graph/cnr-2000
mv mode.txt run_sd_${1}.txt
