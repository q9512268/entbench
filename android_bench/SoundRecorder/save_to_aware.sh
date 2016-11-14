#!/bin/bash

if [ ! -f ./app/src/baware ]; then
  echo "current source is not baware"
  exit
fi

./gradlew clean

rm -rf ./baware
cp -rf ./app/src ./baware
