#!/bin/sh

dir=`dirname "$0"`

if [ $# -ne 1 ]; then
  echo "sd usage: [ESTIMATED_LEVEL]"
  exit
fi

export ENT_SIZE=2
ent -cp $dir/../build/classes crypto.rsa.Main
mv mode.txt run_ld_${1}.txt
