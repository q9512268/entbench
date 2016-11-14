#!/bin/bash

if [ ! -f ./material-life-android/src/baware ]; then
  echo "current source is not baware"
  exit
fi

./gradlew clean

rm -rf ./baware
cp -rf ./material-life-android/src ./baware
