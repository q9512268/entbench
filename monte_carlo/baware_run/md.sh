#!/bin/sh

dir=`dirname "$0"`

if [ $# -ne 1 ]; then
  echo "sd usage: [ESTIMATED_LEVEL]"
  exit
fi

export ENT_SIZE=1
ent -cp $dir/../build/classes monte_carlo.Main
mv mode.txt run_md_${1}.txt