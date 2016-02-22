#!/bin/bash

rm -rf ./sources
cp -rf ./aware sources

ant clean; ant jars
