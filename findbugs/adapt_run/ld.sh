#!/bin/bash

dir=`dirname "$0"`

if [ $# -ne 1 ]; then
  echo "sd usage: [ESTIMATED_LEVEL]"
  exit
fi

level=$1 

# 20138 class files

pfb analyze -maxHeap 2048 -effort:default jboss/jboss-as-7.1.1.Final/modules 
mv $dir/mode.txt $dir/run_ld_${level}.txt
