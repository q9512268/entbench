#!/bin/bash

dir=`dirname "$0"`

pfb analyze -effort:less large
mv $dir/mode.txt $dir/run_ld_mc${1}.txt
