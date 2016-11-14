#!/bin/bash

if [ ! -f ./src/baware ]; then
  echo "current source is not baware"
  exit
fi

./gradlew clean

rm -rf ./baware
cp -rf ./src ./baware
