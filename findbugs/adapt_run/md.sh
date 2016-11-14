#!/bin/bash

dir=`dirname "$0"`

if [ $# -ne 1 ]; then
  echo "sd usage: [ESTIMATED_LEVEL]"
  exit
fi

level=$1 

# 5871 Class files
export PANDA_RUNS=11
export ENT_BATTERY_LEVEL=0.90

pfb analyze -maxHeap 2048 -effort:default rtjar/rt.jar
mv $dir/mode.txt $dir/run_md_${level}.txt
