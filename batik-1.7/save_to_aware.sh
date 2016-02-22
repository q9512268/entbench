#!/bin/bash

if [ ! -f ./sources/aware ]; then
  echo "current source is not aware"
  exit
fi

./bak.sh
rm -rf ./aware
cp -rf ./sources ./aware
