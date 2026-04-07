# AGENTS.md - Agent Guidelines for cloud-demo

This document provides guidelines for agentic coding agents operating in this repository.

## Project Overview

This is a Spring Cloud microservices demo project using:
- **Build Tool**: Maven (multi-module)
- **Java Version**: 21
- **Framework**: Spring Boot 3.5.13
- **Service Discovery**: Alibaba Nacos
- **Service Communication**: OpenFeign
- **Spring Cloud Version**: 2025.0.1
- **Spring Cloud Alibaba Version**: 2025.0.0.0

## Project Structure

```
cloud-demo/
├── pom.xml                    # Parent POM
└── services/
    ├── pom.xml                # Services aggregator
    ├── service-order/         # Order microservice
    └── service-product/       # Product microservice
```

## Build Commands

### Build All Modules
```bash
mvn clean install
```

### Build Single Module
```bash
mvn clean install -pl services/service-order
```

### Run a Service
```bash
cd services/service-order
mvn spring-boot:run
```

### Skip Tests
```bash
mvn clean install -DskipTests
```

### Run a Single Test
```bash
# Using test class name
mvn test -Dtest=OrderServiceTest

# Using method name
mvn test -Dtest=OrderServiceTest#testCreateOrder

# Using wildcard
mvn test -Dtest=*ServiceTest
```

### Run Tests with Coverage
```bash
mvn test jacoco:report
```

### Lint/Format Check
```bash
# Checkstyle
mvn checkstyle:check

# Spotbugs
mvn spotbugs:check

# All validations
mvn verify
```

### Dependency Analysis
```bash
# Show dependency tree
mvn dependency:tree

# Analyze unused dependencies
mvn dependency:analyze
```

## Code Style Guidelines

### General Principles

- Follow Java SE 21 conventions and best practices
- Use Spring Boot 3.x idioms and patterns
- Keep classes focused on single responsibility
- Write concise, readable code

### Naming Conventions

- **Classes**: PascalCase (e.g., `OrderService`, `OrderController`)
- **Methods**: camelCase (e.g., `createOrder`, `findById`)
- **Variables**: camelCase (e.g., `orderId`, `productList`)
- **Constants**: UPPER_SNAKE_CASE (e.g., `MAX_RETRY_COUNT`)
- **Packages**: lowercase (e.g., `com.lxx.order`)

### Import Organization

Order imports in groups with blank lines between:
1. Java/JDK imports
2. Spring Framework imports
3. Third-party library imports
4. Internal project imports

```java
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lxx.order.model.Order;
```

### Type Usage

- Use interfaces over concrete types where appropriate
- Use `Optional` for nullable return values
- Use generics for type safety
- Prefer immutable objects where possible

### Error Handling

- Use custom exceptions for domain-specific errors
- Implement global exception handling with `@ControllerAdvice`
- Return appropriate HTTP status codes (4xx for client errors, 5xx for server errors)
- Include meaningful error messages (not exposing internals in production)

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(OrderNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ErrorResponse(ex.getMessage()));
    }
}
```

### Spring Best Practices

- Use constructor injection over field injection
- Use `@Transactional` for business operations
- Use `@Value` for configuration properties
- Keep controllers thin, delegate to services

```java
@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
```

### REST API Design

- Use nouns for resources (e.g., `/orders`, `/products`)
- Use HTTP verbs appropriately (GET, POST, PUT, DELETE)
- Return standard HTTP status codes
- Use pagination for collections

### Logging

- Use SLF4J for logging
- Include contextual information in log messages
- Avoid excessive logging

```java
private static final Logger log = LoggerFactory.getLogger(OrderService.class);

log.info("Creating order for user: {}", userId);
```

### Testing

- Write unit tests for services and utilities
- Write integration tests for controllers and repositories
- Use @SpringBootTest sparingly, prefer @WebMvcTest, @DataJpaTest
- Follow AAA pattern (Arrange, Act, Assert)

```java
@SpringBootTest
class OrderServiceTest {
    
    @Autowired
    private OrderService orderService;
    
    @Test
    void testCreateOrder() {
        // Arrange
        OrderRequest request = new OrderRequest();
        
        // Act
        Order result = orderService.createOrder(request);
        
        // Assert
        assertNotNull(result.getId());
    }
}
```

## Common Development Tasks

### Adding a New Service Module

1. Create directory under `services/`
2. Add `pom.xml` with appropriate dependencies
3. Add module to `services/pom.xml`
4. Create main application class with `@SpringBootApplication`

### Adding a New Dependency

1. Add to appropriate `pom.xml`
2. Verify with `mvn dependency:tree`
3. Ensure it's compatible with Spring Boot 3.5.13

### Database Configuration

Configure in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/dbname
spring.datasource.username=root
spring.datasource.password=password
```

## Service Ports (Default)

- service-order: 8080
- service-product: 8081

## Additional Notes

- This is a demo project for learning Spring Cloud patterns
- Ensure Nacos is running for service discovery
- Use Spring profiles for environment-specific configuration
