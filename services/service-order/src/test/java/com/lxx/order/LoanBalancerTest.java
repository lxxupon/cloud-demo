package com.lxx.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

@SpringBootTest
public class LoanBalancerTest {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Test
    void test(){
        ServiceInstance choose = loadBalancerClient.choose("service-product");
        System.out.println(choose.getUri());
        choose = loadBalancerClient.choose("service-product");
        System.out.println(choose.getUri());
        choose = loadBalancerClient.choose("service-product");
        System.out.println(choose.getUri());
    }
}
