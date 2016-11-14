#!/bin/bash

rm -rf ./material-life-android/src
cp -rf ./baware ./material-life-android/src

./gradlew clean; ./gradlew installDebug
