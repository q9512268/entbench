#!/bin/bash

if [ ! -f ./material-life-android/src/badapt ]; then
  echo "current source is not badapt"
  exit
fi

./gradlew clean

rm -rf ./badapt
cp -rf ./material-life-android/src ./badapt
