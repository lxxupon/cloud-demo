package com.lxx.order.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
public class OrderConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    Logger.Level getLevel() {
        return Logger.Level.FULL;
    }


    /**
     * 重试策略。
     * 方法1： 如下注入bean
     * 方法2：application.yml设置retryer
     * @return
     */
//    @Bean
    Retryer getRetryer() {
        // openfeign重试策略， 第一次间隔100豪秒，第二次*1.5倍，最大等待1秒，最多重试3次
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 3);
    }
}
