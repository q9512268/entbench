#!/bin/bash

dir=`dirname "$0"`

pfb analyze -effort:min large
mv $dir/mode.txt $dir/run_ld_hc${1}.txt
