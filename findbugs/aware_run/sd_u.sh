#!/bin/bash

dir=`dirname "$0"`

export PANDA_RECOVER=false
pfb analyze small
mv $dir/mode.txt $dir/run_sd_u.txt
