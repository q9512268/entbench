#!/bin/bash

levels=(l m)

for i in `seq 0 1`; do
  for j in `seq 0 1`; do
    ../../timestamp.rb ${levels[$i]}_${levels[$j]}.stamp $1
  done
done

