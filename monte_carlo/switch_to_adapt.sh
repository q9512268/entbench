#!/bin/bash

rm -rf ./src
cp -rf ./adapt src

ant clean; ant
