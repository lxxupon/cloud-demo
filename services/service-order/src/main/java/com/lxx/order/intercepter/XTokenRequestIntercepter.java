package com.lxx.order.intercepter;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class XTokenRequestIntercepter implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        System.out.println("Fegin 拦截器 XTokenRequestIntercepter 启动。。。。");
        template.header("X-Token", UUID.randomUUID().toString());
    }
}
