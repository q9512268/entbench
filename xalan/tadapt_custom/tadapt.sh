#!/bin/bash

dir=`dirname "$0"`

ent -cp .:$dir/../lib/mine/xercesImpl.jar:$dir/../lib/mine/serializer.jar:$dir/../build/xalan.jar:$dir/../tadapt_classes tadapt_custom.XalanBench
