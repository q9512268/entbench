#!/bin/bash

dir=`dirname "$0"`

ent -cp $dir/dist/javalib/constantine.jar:$dir/dist/javalib/guava-r07.jar:$dir/dist/javalib/jnr-posix.jar:$dir/dist/javalib/jaffl.jar:$dir/dist/javalib/asm-3.1.jar:$dir/dist/javalib/asm-commons-3.1.jar:$dir/dist/javalib/antlr-runtime-3.1.3.jar:$dir/dist/jython-dev.jar org.python.util.case_study.CompileTask $@
