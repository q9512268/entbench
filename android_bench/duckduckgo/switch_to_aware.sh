#!/bin/bash

rm -rf ./src
cp -rf ./baware ./src

./gradlew clean; ./gradlew installDebug
