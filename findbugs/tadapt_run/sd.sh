#!/bin/bash

dir=`dirname "$0"`

pfb analyze -effort:max small
mv $dir/mode.txt $dir/run_sd_t.txt
