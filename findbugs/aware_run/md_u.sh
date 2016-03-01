#!/bin/bash

dir=`dirname "$0"`

export PANDA_RECOVER=false
pfb analyze mid
mv $dir/mode.txt $dir/run_md_u.txt
