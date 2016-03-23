#!/bin/sh

dir=`dirname "$0"`

if [ $# -ne 1 ]; then
  echo "sd usage: [ESTIMATED_LEVEL]"
  exit
fi

export PANDA_RUNS=11
export PANDA_RECOVER=true
#export PANDA_RECOVER=false
export ENT_SIZE=1
ent -cp $dir/../build/classes crypto.rsa.Main
mv mode.txt run_md_${1}.txt
