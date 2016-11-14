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

scene=(
  2
  1
  0
)

export PANDA_RUNS=10

for i in `seq 0 0`; do
  for j in `seq 2 2`; do
    rm $dir/materiallife.stamp

    # Setup
    echo "ENT_BATTERY_LEVEL=${blevels[$i]}=float" > $hdir/ent_properties.txt
    echo "LIFE_RULE_CHOICE=${scene[$j]}=int" >> $hdir/ent_properties.txt
    
    for k in `seq 0 ${PANDA_RUNS}`; do

      am start -n com.juankysoriano.materiallife/.activities.GameOfLifeActivity 

      sleep 10

      tstart=`date "+%s"`

      $hdir/replay.exe $hdir/materiallife.log >/dev/null & 
      child=$!

      wait $child

      tend=`date "+%s"`

      echo "ERun ${k}: ${tstart} ${tend}" >> $dir/materiallife.stamp

      am force-stop com.juankysoriano.materiallife

      sleep 30
    done

    mv $dir/materiallife.stamp $dir/run_${datasets[$j]}_${contexts[$i]}.stamp
  done
done




