#!/system/bin/sh

dir=`dirname "$0"`
hdir=$dir/..

use_javascript=(false true)
use_autosearch=(false true)

levels=(l m)

export PANDA_RUNS=9

for i in `seq 0 1`; do
  for j in `seq 0 1`; do
    rm $dir/duckduckgo.stamp

    # Setup
    echo "ENT_BATTERY_LEVEL=0.90=float" > $hdir/ent_properties.txt

    echo "DUCKDUCKGO_USE_JAVASCRIPT=${use_javascript[$i]}=boolean" >> $hdir/ent_properties.txt
    echo "DUCKDUCKGO_USE_AUTOSEARCH=${use_autosearch[$j]}=boolean" >> $hdir/ent_properties.txt

    for k in `seq 0 ${PANDA_RUNS}`; do
    
      am start -n com.duckduckgo.mobile.android/com.duckduckgo.mobile.android.activity.DuckDuckGo

      sleep 10

      tstart=`date "+%s"`

      $hdir/replay.exe $hdir/duckduckgo.log >/dev/null & 
      child=$!

      wait $child

      tend=`date "+%s"`

      echo "ERun ${k}: ${tstart} ${tend}" >> $dir/duckduckgo.stamp

      am force-stop com.duckduckgo.mobile.android

      sleep 30
    done
      
    mv $dir/duckduckgo.stamp ${levels[$i]}_${levels[$j]}.stamp
  done
done




