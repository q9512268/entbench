#!/bin/bash

export PANDA_TADAPT=true
cd ./large
find . -name \*.py -not -path "./test*" | xargs jython-run.sh
cd ..
mv ./large/mode.txt dummy_run_ld_tent.txt

#sleep 120

#export PANDA_TADAPT=false
#cd ./large
#find . -name \*.py -not -path "./test*" | xargs jython-run.sh
#cd ..
#mv ./large/mode.txt run_ld_tjava.txt
