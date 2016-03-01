#!/bin/bash

dir=`dirname "$0"`

if [ $# -ne 1 ]; then
  echo "sd usage: [ESTIMATED_LEVEL]"
  exit
fi

level=$1 

export PANDA_BATTERY_RUN=true

pfb analyze -effort:max jboss
mv $dir/mode.txt $dir/run_sd_${level}.txt
