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

adb pull /data/local/tmp/materiallife/over_run/run_md_mc_java.stamp

