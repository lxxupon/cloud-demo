#!/bin/sh

APPLICATION="gateway-1.0.jar"
JAVA_OPT="${JAVA_OPTS} -server -Xms512m -Xmx512m -Xmn256m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=128m"
JAVA_OPT="${JAVA_OPT} -XX:-OmitStackTraceInFastThrow"
java ${JAVA_OPT} -jar -Djava.security.egd=file:/dev/./urandom -Dloader.path=.,resources,lib ${APPLICATION}   >> nohup.out  2>&1 &