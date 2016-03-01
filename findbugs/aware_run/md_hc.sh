#!/bin/bash

dir=`dirname "$0"`

pfb analyze -effort:min mid
mv $dir/mode.txt $dir/run_md_hc${1}.txt
