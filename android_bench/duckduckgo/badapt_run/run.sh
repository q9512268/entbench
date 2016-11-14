#!/system/bin/sh

dir=`dirname "$0"`
hdir=$dir/../..


contexts=(
  hc
  mc
  lc
)

blevels=(
  0.90
  0.70
  0.40
) 

datasets=(
  sd
  md
  ld
)

export PANDA_RUNS=9

for i in `seq 1 1`; do
  for j in `seq 1 1`; do
    rm $dir/duckduckgo.stamp

    # Setup
    echo "ENT_BATTERY_LEVEL=${blevels[$i]}=float" > $hdir/ent_properties.txt

    for k in `seq 0 ${PANDA_RUNS}`; do
      am start -n com.duckduckgo.mobile.android/com.duckduckgo.mobile.android.activity.DuckDuckGo

      sleep 10

      tstart=`date "+%s"`

      $hdir/replay.exe $hdir/duckduckgo_${datasets[$j]}.log >/dev/null & 
      child=$!

      wait $child

      tend=`date "+%s"`

      echo "ERun ${k}: ${tstart} ${tend}" >> $dir/duckduckgo.stamp

      am force-stop com.duckduckgo.mobile.android

      sleep 30
    done
      
    mv $dir/duckduckgo.stamp $dir/run_${datasets[$j]}_${contexts[$i]}.stamp
  done
done




