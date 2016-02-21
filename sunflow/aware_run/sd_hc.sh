#!/bin/bash

dir=`dirname "$0"`

panda -cp $dir/../build/classes:$dir/../janino.jar SunflowGUI -aa 0 0 -nogui $dir/small.sc
mv $dir/mode.txt $dir/run_sd_hc${1}.txt
