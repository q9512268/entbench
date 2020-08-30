#!/bin/bash
ant clean
ant compile -v

dir=`dirname "$0"`

ent -cp $dir/build/classes monte_carlo.Main
