#!/bin/bash

ip=192.168.0.16

if [ $# -eq 1 ]; then
  ip=$1
fi

adb disconnect ${ip}:5150
