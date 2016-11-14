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

recover=(true false)

protection=(p u)

export PANDA_RUNS=9

for l in `seq 0 0`; do 
  for i in `seq 1 1`; do
    for j in `seq 1 1`; do
      rm $dir/soundrecorder.stamp

      # Setup
      echo "ENT_BATTERY_LEVEL=${blevels[$i]}=float" > $hdir/ent_properties.txt
      echo "ENT_RECOVER=${recover[$l]}=boolean" >> $hdir/ent_properties.txt

      for k in `seq 0 ${PANDA_RUNS}`; do
        am start -n com.danielkim.soundrecorder/com.danielkim.soundrecorder.activities.MainActivity

        sleep 20

        tstart=`date "+%s"`

        $hdir/replay.exe $hdir/soundrecorder_${datasets[$j]}_baware.log >/dev/null & 

        child=$!

        wait $child

        tend=`date "+%s"`

        echo "ERun ${k}: ${tstart} ${tend}" >> $dir/soundrecorder.stamp

        am force-stop com.danielkim.soundrecorder

        sleep 30
      done
        
      mv $dir/soundrecorder.stamp $dir/run_${datasets[$j]}_${contexts[$i]}_java.stamp
    done
  done
done



