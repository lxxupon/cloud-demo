FROM eclipse-temurin:21-jre-jammy

RUN mkdir -p /home/seata-product-service
WORKDIR /home/seata-product-service
COPY *.jar /home/seata-product-service/
COPY *.sh /home/seata-product-service/
COPY lib/ /home/seata-product-service/lib/
COPY resources/ /home/seata-product-service/resources/

RUN chmod +x *.sh

ENTRYPOINT ["sh", "-c", "/home/seata-product-service/start.sh"]