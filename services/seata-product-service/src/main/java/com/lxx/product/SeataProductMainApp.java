package com.lxx.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient // 开启服务发现功能
@SpringBootApplication
public class SeataProductMainApp {

    public static void main(String[] args) {
        SpringApplication.run(SeataProductMainApp.class, args);
    }
}
