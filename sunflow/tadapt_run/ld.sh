#!/bin/bash

dir=`dirname "$0"`

export PANDA_TADAPT=true
ent -cp $dir/../build/classes:$dir/../janino.jar SunflowGUI -aa -1 1 -nogui $dir/large.sc
mv $dir/mode.txt $dir/run_ld_tent.txt

sleep 60

export PANDA_TADAPT=false
ent -cp $dir/../build/classes:$dir/../janino.jar SunflowGUI -aa -1 1 -nogui $dir/large.sc
mv $dir/mode.txt $dir/run_ld_tjava.txt
