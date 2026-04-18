package com.lxx.cloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@ConfigurationProperties(prefix = "order")  // 配置批量绑定再nacos下，可以无需RefreshScope就能自动刷新
@Component
public class OrderProperties {
    private String timeout;
    private String autoConfirm;
    private String dbUrl;
}
