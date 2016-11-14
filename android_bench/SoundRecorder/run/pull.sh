#!/bin/bash

levels=(l m h)

for i in `seq 0 2`; do
  for j in `seq 0 2`; do
    adb pull /data/local/tmp/soundrecorder/${levels[$i]}_${levels[$j]}.stamp
  done
done

