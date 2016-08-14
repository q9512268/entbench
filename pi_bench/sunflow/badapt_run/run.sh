#!/bin/bash

dir=`dirname "$0"`

if [ $# -ne 1 ]; then
  echo "run.sh usage: [ESTIMATED_LEVEL]"
  exit
fi

level=$1

export PANDA_RUNS=6
ent -cp $dir/../build/classes:$dir/../janino.jar SunflowGUI -nogui $dir/gumbo_and_teapot.sc
mv $dir/mode.txt $dir/${level}_level_mode.txt
