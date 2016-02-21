#!/bin/bash

dir=`dirname "$0"`

export PANDA_TADAPT=true
panda -cp $dir/../build/classes:$dir/../janino.jar SunflowGUI -aa 0 1 -nogui $dir/large.sc 
mv $dir/mode.txt $dir/run_ld_tent.txt

#sleep 120

#export PANDA_TADAPT=false
#panda -cp $dir/../build/classes:$dir/../janino.jar SunflowGUI -aa 0 1 -nogui $dir/large.sc
#mv $dir/mode.txt $dir/run_ld_tjava.txt
