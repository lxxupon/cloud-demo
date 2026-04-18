# FROM openjdk:8u342-slim-buster
# FROM openjdk:11.0.16-slim-buster
# FROM openjdk:11.0.16-jdk

FROM eclipse-temurin:21-jre-jammy

# 创建运行目录
RUN mkdir -p /home/gateway
# 更改运行的当前目录
WORKDIR /home/gateway
# 添加所有文件
COPY *.jar /home/gateway/
COPY *.sh /home/gateway/
COPY lib/ /home/gateway/lib/
COPY resources/ /home/gateway/resources/

# 拷贝完后经常失去执行能力
RUN chmod +x *.sh

ENTRYPOINT ["sh", "-c", "/home/gateway/start.sh"]