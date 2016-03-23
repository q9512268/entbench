#!/bin/bash

rm -rf ./src
cp -rf ./baware src

ant clean; ant
