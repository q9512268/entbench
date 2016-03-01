#!/bin/bash

dir=`dirname "$0"`

export PANDA_TADAPT=true
pfb analyze -effort:max large
mv $dir/mode.txt $dir/run_ld_tent.txt

#sleep 120

#export PANDA_TADAPT=false
#pfb analyze -effort:max large
#mv $dir/mode.txt $dir/run_ld_tjava.txt
