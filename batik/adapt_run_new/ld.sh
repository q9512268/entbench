#!/bin/sh

dir=`dirname "$0"`

ent -cp $dir/../classes:$dir/../lib/xalan-2.6.0.jar:$dir/../lib/xerces_2_5_0.jar:$dir/../lib/xml-apis-ext.jar:$dir/../lib/xml-apis.jar:$dir/../resources org.apache.batik.apps.rasterizer.Main -m image/jpeg -w 2048 $dir/mapWaadt.svg $dir/mapSpain.svg $dir/sydney.svg $dir/asf-logo.svg $dir/moonPhases.svg $dir/batik3D.svg $dir/strokeFont.svg

mv $dir/mode.txt $dir/run_ld_${1}.txt
