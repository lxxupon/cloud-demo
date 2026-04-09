package com.lxx.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @auther lxx
 * @create 2026-04-08 15:22
 */
@SpringBootApplication
@MapperScan("com.lxx.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient //服务注册和发现
@EnableFeignClients
public class SeataOrderMainApp {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp.class, args);
    }
}