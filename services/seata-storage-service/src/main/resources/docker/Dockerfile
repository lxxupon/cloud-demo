FROM eclipse-temurin:21-jre-jammy

RUN mkdir -p /home/seata-storage-service
WORKDIR /home/seata-storage-service
COPY *.jar /home/seata-storage-service/
COPY *.sh /home/seata-storage-service/
COPY lib/ /home/seata-storage-service/lib/
COPY resources/ /home/seata-storage-service/resources/

RUN chmod +x *.sh

ENTRYPOINT ["sh", "-c", "/home/seata-storage-service/start.sh"]