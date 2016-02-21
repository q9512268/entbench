#!/bin/bash

rm -rf ./src
cp -rf ./aware src

ant clean; ant
