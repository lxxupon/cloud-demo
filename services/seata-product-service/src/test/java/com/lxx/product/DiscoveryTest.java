package com.lxx.product;

import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class DiscoveryTest {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    NacosServiceDiscovery nacosServiceDiscovery;

    @Test
    void discoveryClientTest() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("ip:" + instance.getHost() + "; " + "port:" + instance.getPort());
            }
        }
    }

    @Test
    void nacosServiceDiscoveryTest() throws Exception {
        List<String> services = nacosServiceDiscovery.getServices();
        for (String service : services) {
            System.out.println(service);
            List<ServiceInstance> instances = nacosServiceDiscovery.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println("ip:" + instance.getHost() + "; " + "port:" + instance.getPort());
            }
        }
    }
}
