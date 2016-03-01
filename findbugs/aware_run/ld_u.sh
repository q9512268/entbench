#!/bin/bash

dir=`dirname "$0"`

export PANDA_RECOVER=false
pfb analyze large
mv $dir/mode.txt $dir/run_ld_u.txt
