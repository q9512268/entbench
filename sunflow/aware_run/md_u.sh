#!/bin/bash

dir=`dirname "$0"`

export PANDA_RECOVER=false
ent -cp $dir/../build/classes:$dir/../janino.jar SunflowGUI -aa 0 2 -nogui $dir/medium.sc
mv $dir/mode.txt $dir/run_md_u.txt
