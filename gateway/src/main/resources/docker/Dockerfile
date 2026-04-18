# FROM openjdk:8u342-slim-buster
# FROM openjdk:11.0.16-slim-buster
# FROM openjdk:11.0.16-jdk

FROM openjdk:8u342-jdk

# 创建运行目录
RUN mkdir -p /opt/mcs_gateway
# 更改运行的当前目录
WORKDIR /opt/mcs_gateway
# 添加所有文件
COPY *.jar /opt/mcs_gateway/
COPY *.sh /opt/mcs_gateway/
COPY lib/ /opt/mcs_gateway/lib/
COPY resources/ /opt/mcs_gateway/resources/

# 拷贝完后经常失去执行能力
RUN chmod +x *.sh

ENTRYPOINT ["sh", "-c", "/opt/mcs_gateway/start.sh"]