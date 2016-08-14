#!/bin/bash

export PANDA_PAGERANK_ALPHA="0.50"
ent -cp ../classes:../lib/collections-generic-4.01.jar:../lib/colt-1.2.0.jar util.PageRankBench graphs/barabasi-50000.txt
mv mode.txt run_md.txt
