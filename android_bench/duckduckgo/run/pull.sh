#!/bin/bash

levels=(l m)

for i in `seq 0 1`; do
  for j in `seq 0 1`; do
    adb pull /data/local/tmp/duckduckgo/${levels[$i]}_${levels[$j]}.stamp
  done
done

