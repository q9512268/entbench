#!/bin/bash

if [ ! -f ./src/badapt ]; then
  echo "current source is not badapt"
  exit
fi

./gradlew clean

rm -rf ./badapt
cp -rf ./src ./badapt
