#!/bin/bash

rm -rf ./app/src
cp -rf ./badapt ./app/src

./gradlew clean; ./gradlew installDebug
