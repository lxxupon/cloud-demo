# AGENTS.md - cloud-demo

## Project Structure
- **Build**: Maven (multi-module), Java 21, Spring Boot 3.5.13
- **Modules**: 7 total
  - `services/`: seata-order-service, seata-account-service, seata-storage-service, seata-product-service
  - `model/`: shared models
  - `gateway/`: API gateway (8082)
  - `common-swagger/`: Swagger/OpenAPI config

## Build Commands
```bash
mvn clean install                              # Build all
mvn clean install -pl services/seata-order-service # Build single module
mvn clean install -DskipTests               # Skip tests
mvn test -Dtest=OrderServiceTest            # Run single test class
```

## Run Services
```bash
mvn spring-boot:run -pl services/seata-order-service  # Run single service
```
Prerequisites: Nacos (8848), Seata (8091), Sentinel (8080) must be running externally.

## Service Ports
- seata-order-service: 8080
- seata-account-service: 8081
- seata-storage-service: 8082
- seata-product-service: 8083
- gateway: 8082
- Nacos: 8848
- Seata: 8091
- Sentinel console: 8080

## Key References
- `readme.md`: Tech stack versions
- `pom.xml`: Parent versions (Spring Boot 3.5.13, Cloud 2025.0.1, Alibaba 2025.0.0.0)