package com.lxx.cloud.config;

import com.lxx.cloud.SpringDocProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@AutoConfiguration
@EnableConfigurationProperties(SpringDocProperties.class)
public class SpringDocAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "springdoc.info", name = "title")
    public OpenAPI customOpenAPI(SpringDocProperties properties) {
        log.info("------------注入 OpenAPI bean");

        return new OpenAPI()
                .info(new Info()
                        .title(properties.getTitle())
                        .version(properties.getVersion())
                        .description(properties.getDescription())
                        .contact(new Contact().name("开发团队").email("dev@example.com"))
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }
}
