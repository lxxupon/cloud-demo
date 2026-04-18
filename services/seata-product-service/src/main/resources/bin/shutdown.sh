#!/bin/sh
#======================================================================
# 项目停服shell脚本
#======================================================================

APPLICATION="seata-product-service-1.0.jar"
APPLICATION_JAR="${APPLICATION}"
PID=$(ps -ef | grep "${APPLICATION_JAR}" | grep -v grep | awk '{ print $2 }')
if [[ -z "$PID" ]]
then
    echo ${APPLICATION} is already stopped
else
    echo kill ${PID}
    kill -9 ${PID}
    echo ${APPLICATION} stopped successfully
fi
