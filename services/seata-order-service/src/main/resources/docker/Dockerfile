FROM eclipse-temurin:21-jre-jammy

RUN mkdir -p /home/seata-order-service
WORKDIR /home/seata-order-service
COPY *.jar /home/seata-order-service/
COPY *.sh /home/seata-order-service/
COPY lib/ /home/seata-order-service/lib/
COPY resources/ /home/seata-order-service/resources/

RUN chmod +x *.sh

ENTRYPOINT ["sh", "-c", "/home/seata-order-service/start.sh"]