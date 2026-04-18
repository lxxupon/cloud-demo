#!/bin/sh
#======================================================================
# 项目重启shell脚本
#======================================================================

APPLICATION="seata-order-service-1.0.jar"

echo stop ${APPLICATION} Application...
sh shutdown.sh

ti1=`date +%s`
ti2=`date +%s`
i=$(($ti2 - $ti1 ))

while [[ "$i" -ne "3" ]]
do
    ti2=`date +%s`
    i=$(($ti2 - $ti1 ))
done

echo start ${APPLICATION} Application...
sh start.sh
