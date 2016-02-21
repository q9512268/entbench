#!/bin/bash

dir=`dirname "$0"`

if [ $# -ne 1 ]; then
  echo "sd usage: [ESTIMATED_LEVEL]"
  exit
fi

level=$1 

export PANDA_BATTERY_RUN=true

panda -cp $dir/../build/classes:$dir/../janino.jar SunflowGUI -aa 0 1 -nogui $dir/small.sc
mv $dir/mode.txt $dir/run_sd_${level}.txt
