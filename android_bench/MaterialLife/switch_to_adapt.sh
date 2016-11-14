#!/bin/bash

rm -rf ./material-life-android/src
cp -rf ./badapt ./material-life-android/src

./gradlew clean; ./gradlew installDebug
