#!/bin/bash

dir=`dirname "$0"`

if [ $# -ne 1 ]; then
  echo "sd usage: [ESTIMATED_LEVEL]"
  exit
fi

export PANDA_RUNS=21

runs=(
  sd.sh
  md.sh
  ld.sh
)

for rn in ${runs[@]}; do
  echo "Starting ${rn}"
  $(./$rn $1 > /dev/null)  
  echo "Completed ${rn}"
  sleep 10
done
