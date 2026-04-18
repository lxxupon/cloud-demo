FROM eclipse-temurin:21-jre-jammy

RUN mkdir -p /home/seata-account-service
WORKDIR /home/seata-account-service
COPY *.jar /home/seata-account-service/
COPY *.sh /home/seata-account-service/
COPY lib/ /home/seata-account-service/lib/
COPY resources/ /home/seata-account-service/resources/

RUN chmod +x *.sh

ENTRYPOINT ["sh", "-c", "/home/seata-account-service/start.sh"]