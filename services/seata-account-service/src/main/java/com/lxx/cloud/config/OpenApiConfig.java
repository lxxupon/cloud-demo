package com.lxx.cloud.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@Configuration
public class OpenApiConfig {

    @Value("${spring.application.name:unknown-service}")
    private String appName;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(appName + " API 文档")
                        .version("1.0.0")
                        .description("基于 Spring Boot 3.5 + SpringDoc 2.8.17 的微服务接口文档")
                        .contact(new Contact().name("开发团队").email("dev@example.com"))
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                .addServersItem(new Server().url("http://localhost:2003").description("本地开发环境"))
                ;
    }
}