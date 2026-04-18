# Cloud Demo

Spring Cloud 微服务架构 Demo

## 技术栈版本

| 组件 | 版本 | 下载地址 |
|------|------|----------|
| Spring Boot | 3.5.13 | [spring.io](https://spring.io/projects/spring-boot) |
| Java | 21 | [oracle.com](https://www.oracle.com/java/technologies/downloads/) |
| Spring Cloud | 2025.0.1 | [spring.io](https://spring.io/projects/spring-cloud) |
| Spring Cloud Alibaba | 2025.0.0.0 | [spring-cloud-alibaba](https://github.com/alibaba/spring-cloud-alibaba) |
| Seata | 2.5.0 | [apache/incubator-seata](https://github.com/apache/incubator-seata/releases/tag/v2.5.0) |
| Sentinel | 1.8.9 | [alibaba/Sentinel](https://github.com/alibaba/Sentinel/releases/tag/1.8.9) |
| Nacos Client | 3.0.3 | [nacos.io](https://nacos.io/download/) |

## 项目结构

```
cloud-demo/
├── pom.xml                    # 父POM
├── services/                  # 微服务模块
│   ├── seata-order-service/   # Seata订单服务
│   ├── seata-account-service/ # Seata账户服务
│   ├── seata-storage-service/ # Seata库存服务
│   └── seata-product-service/ # Seata商品服务
├── model/                     # 公共模型
├── gateway/                   # 网关服务
└── common-swagger/           # Swagger配置
```

## 快速开始

### 构建项目

```bash
mvn clean install
```

### 启动服务

1. 启动 Nacos 服务端
2. 启动 Seata 服务端
3. 启动 Sentinel 控制台
4. 运行各微服务

### 服务端口

- seata-order-service: 8080
- seata-account-service: 8081
- seata-storage-service: 8082
- seata-product-service: 8083
- gateway: 8082