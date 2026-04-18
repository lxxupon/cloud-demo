package com.lxx.cloud;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Slf4j
@Data
@ConfigurationProperties(prefix = SpringDocProperties.PREFIX)
public class SpringDocProperties implements InitializingBean {
    public static final String PREFIX = "springdoc.info";
    private String title;
    private String description;
    private String version;
//    private String serverUrl;

    @Override
    public void afterPropertiesSet() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(this);
        log.info("SpringDocProperties:{}", s);
    }
}
