#!/bin/bash

rm -rf ./src
cp -rf ./badapt ./src

./gradlew clean; ./gradlew installDebug
