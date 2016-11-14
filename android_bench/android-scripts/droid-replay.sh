#!/bin/bash

if [ $# -ne 1 ]; then
  echo "droid-replay usage: [TRACE]"
fi

adb shell /data/local/tmp/replay.exe /data/local/tmp/${1}.log
