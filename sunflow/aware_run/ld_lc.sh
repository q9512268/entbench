#!/bin/bash

dir=`dirname "$0"`

panda -cp $dir/../build/classes:$dir/../janino.jar SunflowGUI -aa 0 2 -nogui $dir/large.sc
mv $dir/mode.txt $dir/run_ld_lc${1}.txt
