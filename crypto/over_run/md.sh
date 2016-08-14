#!/bin/sh

dir=`dirname "$0"`

if [ $# -ne 1 ]; then
  echo "sd usage: [ESTIMATED_LEVEL]"
  exit
fi

export ENT_SIZE=1
export PANDA_RUNS=11
export ENT_BATTERY_LEVEL=0.70
ent -cp $dir/../build/classes crypto.rsa.Main
mv mode.txt run_md_${1}_java.txt
