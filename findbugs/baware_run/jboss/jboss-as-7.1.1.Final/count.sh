#!/bin/bash

class=0

for i in $(find . -name "*.jar"); do
  for j in $(jar -tf ${i}); do
    if [[ ${j} == *.class ]]; then
      ((class++))
    fi
  done
done

echo $class

