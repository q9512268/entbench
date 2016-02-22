#!/bin/bash

if [ ! -f ./sources/adapt ]; then
  echo "current source is not adapt"
  exit
fi

./bak.sh
rm -rf ./adapt
cp -rf ./sources ./adapt
