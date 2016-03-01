#!/bin/bash

dir=`dirname "$0"`

pfb analyze -effort:max large
mv $dir/mode.txt $dir/run_ld_lc${1}.txt
