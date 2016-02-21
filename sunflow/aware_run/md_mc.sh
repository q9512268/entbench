#!/bin/bash

dir=`dirname "$0"`

panda -cp $dir/../build/classes:$dir/../janino.jar SunflowGUI -aa 0 1 -nogui $dir/medium.sc
mv $dir/mode.txt $dir/run_md_mc${1}.txt
