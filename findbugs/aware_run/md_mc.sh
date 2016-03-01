#!/bin/bash

dir=`dirname "$0"`

pfb analyze -effort:less mid
mv $dir/mode.txt $dir/run_md_mc${1}.txt
