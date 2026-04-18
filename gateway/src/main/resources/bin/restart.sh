#!/bin/sh
#======================================================================
# 项目重启shell脚本
# 先调用shutdown.sh停服
# 然后调用startup.sh启动服务
#
# author:liyu
# date: 2020-03-21
#======================================================================

# 项目名称
APPLICATION="gateway-1.0.jar"

# 停服
echo stop ${APPLICATION} Application...
sh shutdown.sh

ti1=`date +%s`    #获取时间戳
ti2=`date +%s`
i=$(($ti2 - $ti1 ))

while [[ "$i" -ne "3" ]]
do
	ti2=`date +%s`
	i=$(($ti2 - $ti1 ))
done
# 启动服务
echo start ${APPLICATION} Application...
sh start.sh
