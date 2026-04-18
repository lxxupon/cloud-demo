#!/bin/sh
#======================================================================
# 项目停服shell脚本
# 通过项目名称查找到PID
# 然后kill -9 pid
#
# author: liyu
# date: 2020-03-21
#======================================================================

# 项目名称
APPLICATION="gateway-1.0.jar"

# 项目启动jar包名称
APPLICATION_JAR="${APPLICATION}"
PID=$(ps -ef | grep "${APPLICATION_JAR}" | grep -v grep | awk '{ print $2 }')
if [[ -z "$PID" ]]
then
    echo ${APPLICATION} is already stopped
else
    echo kill  ${PID}
    kill -9 ${PID}
    echo ${APPLICATION} stopped successfully
fi
