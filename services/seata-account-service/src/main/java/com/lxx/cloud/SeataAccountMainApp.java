package com.lxx.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @auther lxx
 * @create 2026-04-08 16:11
 */
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.lxx.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@SpringBootApplication
public class SeataAccountMainApp {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMainApp.class, args);
    }
}