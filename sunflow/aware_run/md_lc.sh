#!/bin/bash

dir=`dirname "$0"`

ent -cp $dir/../build/classes:$dir/../janino.jar SunflowGUI -aa 0 2 -nogui $dir/medium.sc
mv $dir/mode.txt $dir/run_md_lc${1}.txt
