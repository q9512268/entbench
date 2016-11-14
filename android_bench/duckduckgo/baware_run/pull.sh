#!/bin/bash

contexts=(
  hc
  mc
  lc
)

datasets=(
  sd
  md
  ld
)

protection=(u p)

for k in `seq 0 1`; do
  for i in `seq 0 2`; do
    for j in `seq 0 2`; do
      adb pull /data/local/tmp/duckduckgo/baware_run/run_${datasets[$j]}_${contexts[$i]}_${protection[$k]}.stamp
    done
  done
done

