#!/bin/sh

dir=`dirname "$0"`

#export PANDA_TADAPT=false
#panda -cp .:$dir/../lib/mine/xercesImpl.jar:$dir/../lib/mine/serializer.jar:$dir/../build/xalan.jar:$dir/../tadapt_classes tadapt_custom.XalanBench
#mv mode.txt run_ld_over_tjava.txt

export PANDA_TADAPT=true
panda -cp .:$dir/../lib/mine/xercesImpl.jar:$dir/../lib/mine/serializer.jar:$dir/../build/xalan.jar:$dir/../tadapt_classes tadapt_custom.XalanBench
mv mode.txt run_md_mc_ent.txt
#mv mode.txt run_md_mc_java.txt

#export PANDA_TADAPT=false
#panda -cp .:$dir/../lib/mine/xercesImpl.jar:$dir/../lib/mine/serializer.jar:$dir/../build/xalan.jar:$dir/../tadapt_classes tadapt_custom.XalanBench
#mv mode.txt run_ld_over_tjava.txt
