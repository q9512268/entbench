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

for i in `seq 0 2`; do
  for j in `seq 0 2`; do
    adb pull /data/local/tmp/materiallife/badapt_run/run_${datasets[$j]}_${contexts[$i]}.stamp
  done
done

