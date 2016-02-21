#!/bin/bash

dir=`dirname "$0"`

panda -cp $dir/../build/classes:$dir/../janino.jar SunflowGUI -aa 0 0 -nogui $dir/large.sc
mv $dir/mode.txt $dir/run_ld_hc${1}.txt
