#!/bin/bash

dir=`dirname "$0"`

pfb analyze -effort:less small
mv $dir/mode.txt $dir/run_sd_mc${1}.txt
