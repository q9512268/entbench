#!/bin/bash

dir=`dirname "$0"`

if [ $# -ne 1 ]; then
  echo "sd usage: [ESTIMATED_LEVEL]"
  exit
fi

level=$1 

pfb analyze -maxHeap 2048 -effort:default drjava/drjava-stable-20140826-r5761.jar
mv $dir/mode.txt $dir/run_sd_${level}.txt
