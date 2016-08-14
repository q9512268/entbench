#!/bin/sh

dir=`dirname "$0"`

export PANDA_BATTERY_RUN=true

ent -cp $dir/../classes:$dir/../lib/xalan-2.6.0.jar:$dir/../lib/xerces_2_5_0.jar:$dir/../lib/xml-apis-ext.jar:$dir/../lib/xml-apis.jar:$dir/../resources org.apache.batik.apps.rasterizer.Main -m image/jpeg -w 1024 $dir/asf-logo.svg $dir/batik3D.svg $dir/batikFX.svg $dir/batikLogo.svg $dir/large.svg $dir/mapSpain.svg $dir/mapWaadt.svg $dir/medium.svg $dir/moonPhases.svg $dir/small.svg $dir/strokeFont.svg $dir/asf-logo.svg $dir/batik3D.svg $dir/batikFX.svg $dir/batikLogo.svg $dir/large.svg $dir/mapSpain.svg $dir/mapWaadt.svg $dir/medium.svg $dir/moonPhases.svg $dir/small.svg $dir/strokeFont.svg $dir/asf-logo.svg $dir/batik3D.svg $dir/batikFX.svg $dir/batikLogo.svg $dir/large.svg $dir/mapSpain.svg $dir/mapWaadt.svg $dir/medium.svg $dir/moonPhases.svg $dir/small.svg $dir/strokeFont.svg $dir/asf-logo.svg $dir/batik3D.svg $dir/batikFX.svg $dir/batikLogo.svg $dir/large.svg $dir/mapSpain.svg $dir/mapWaadt.svg $dir/medium.svg $dir/moonPhases.svg $dir/small.svg $dir/strokeFont.svg 

mv $dir/mode.txt $dir/run_md_${1}.txt
