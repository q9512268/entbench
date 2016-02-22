#!/bin/sh

dir=`dirname "$0"`

export PANDA_JSPIDER_TILE=0
for i in $(seq 1 10); do

ent -cp $dir/../classes:$dir/../lib/xalan-2.6.0.jar:$dir/../lib/xerces_2_5_0.jar:$dir/../lib/xml-apis-ext.jar:$dir/../lib/xml-apis.jar:$dir/../resources org.apache.batik.apps.rasterizer.Main -m image/tiff large5.svg

mv $dir/mode.txt $dir/${PANDA_JSPIDER_TILE}_${i}_tif.txt

done
