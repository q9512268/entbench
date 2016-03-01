#!/bin/bash

dir=`dirname "$0"`

pfb analyze -effort:min small
mv $dir/mode.txt $dir/run_sd_hc${1}.txt
