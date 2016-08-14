#!/bin/sh

dir=`dirname "$0"`

#export PANDA_TADAPT=false
#panda -cp .:$dir/../lib/mine/xercesImpl.jar:$dir/../lib/mine/serializer.jar:$dir/../build/xalan.jar:$dir/../tadapt_classes tadapt_custom.XalanBench
#mv mode.txt run_ld_tjava.txt

export PANDA_TADAPT=true
ent -cp .:$dir/../lib/mine/xercesImpl.jar:$dir/../lib/mine/serializer.jar:$dir/../build/xalan.jar:$dir/../tadapt_classes tadapt_custom.XalanBench
mv mode.txt dummy_run_ld_tent.txt
