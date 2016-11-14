#!/bin/bash

dir=`dirname "$0"`

_term() {
  kill -TERM "$child" 2>/dev/null
}

trap _term SIGINT

if [ $# -ne 1 ]; then
  echo "droid-record usage: [OUTPUT NAME]"
  echo "script will handle extensions, dont use them"
  exit
fi

adb shell getevent -tt > ${1}.txt &

child=$!
wait "$child"

while read line; do
  if [[ $line =~ \[.* ]]; then
    echo $line >> ${1}.tmp
  fi
done <${1}.txt

cp ${1}.txt ${1}.old.txt
mv ${1}.tmp ${1}.txt

java -cp $dir/RERAN Translate ${1}.txt ${1}.log 
