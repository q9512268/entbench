#!/system/bin/sh

dir=`dirname "$0"`
hdir=$dir/..

bitrate=(32 96 160)
samplerate=(8 24 48)

levels=(l m h)

export PANDA_RUNS=9

for i in `seq 0 2`; do
  for j in `seq 0 2`; do
    rm $dir/soundrecorder.stamp

    # Setup
    echo "ENT_BATTERY_LEVEL=0.90=float" > $hdir/ent_properties.txt

    echo "SOUNDRECORDER_BITRATE=${bitrate[$i]}=int" >> $hdir/ent_properties.txt
    echo "SOUNDRECORDER_SAMPLERATE=${samplerate[$j]}=int" >> $hdir/ent_properties.txt

    for k in `seq 0 ${PANDA_RUNS}`; do
    
      am start -n com.danielkim.soundrecorder/com.danielkim.soundrecorder.activities.MainActivity

      sleep 20

      tstart=`date "+%s"`

      $hdir/replay.exe $hdir/soundrecorder.log >/dev/null & 
      child=$!

      wait $child

      tend=`date "+%s"`

      echo "ERun ${k}: ${tstart} ${tend}" >> $dir/soundrecorder.stamp

      am force-stop com.danielkim.soundrecorder

      sleep 30
    done
      
    mv $dir/soundrecorder.stamp ${levels[$i]}_${levels[$j]}.stamp
  done
done




