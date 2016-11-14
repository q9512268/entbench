#!/bin/bash

if [ $# -ne 1 ]; then
  echo "droid-push.sh usage: [FILE] [PTH]"
fi

adb push $1 /data/local/tmp/$2
adb shell chmod 777 /data/local/tmp/$2/$1
