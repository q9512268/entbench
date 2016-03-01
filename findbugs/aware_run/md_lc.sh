#!/bin/bash

dir=`dirname "$0"`

pfb analyze -effort:max mid
mv $dir/mode.txt $dir/run_md_lc${1}.txt
