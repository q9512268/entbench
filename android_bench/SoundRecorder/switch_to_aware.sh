#!/bin/bash

rm -rf ./app/src
cp -rf ./baware ./app/src

./gradlew clean; ./gradlew installDebug
