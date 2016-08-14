#!/bin/bash

dir=`dirname "$0"`

panda -cp $dir/lib/mine/xercesImpl.jar:$dir/lib/mine/serializer.jar:$dir/build/xalan.jar org.apache.xalan.xslt.Process "$@"
