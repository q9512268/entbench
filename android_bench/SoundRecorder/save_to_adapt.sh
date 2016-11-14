#!/bin/bash

if [ ! -f ./app/src/badapt ]; then
  echo "current source is not badapt"
  exit
fi

./gradlew clean

rm -rf ./badapt
cp -rf ./app/src ./badapt
