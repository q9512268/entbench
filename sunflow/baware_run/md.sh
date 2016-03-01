#!/bin/bash

dir=`dirname "$0"`

if [ $# -ne 1 ]; then
  echo "sd usage: [ESTIMATED_LEVEL]"
  exit
fi

level=$1 

export PANDA_BATTERY_RUN=true

ent -cp $dir/../build/classes:$dir/../janino.jar SunflowGUI -aa -1 1 -nogui $dir/medium.sc
mv $dir/mode.txt $dir/run_md_${level}.txt
mv $dir/output.png $dir/output_md_${level}.png
