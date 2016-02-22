#!/bin/sh

dir=`dirname "$0"`

export PANDA_BATTERY_RUN=true

ent -cp $dir/../classes:$dir/../lib/xalan-2.6.0.jar:$dir/../lib/xerces_2_5_0.jar:$dir/../lib/xml-apis-ext.jar:$dir/../lib/xml-apis.jar:$dir/../resources org.apache.batik.apps.rasterizer.Main -m image/jpeg -w 4096 $dir/large.svg 

mv $dir/mode.txt $dir/run_ld_${1}.txt
