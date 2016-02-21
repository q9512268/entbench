#!/bin/bash

rm -rf ./src
cp -rf ./tadapt src

ant clean; ant
