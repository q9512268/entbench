#!/bin/bash

rm -rf ./sources
cp -rf ./adapt sources

ant clean; ant jars
