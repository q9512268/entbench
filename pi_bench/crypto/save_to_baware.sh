#!/bin/bash

if [ ! -f ./src/baware ]; then
  echo "current source is not baware"
  exit
fi

./bak.sh
rm -rf ./baware
cp -rf ./src ./baware
