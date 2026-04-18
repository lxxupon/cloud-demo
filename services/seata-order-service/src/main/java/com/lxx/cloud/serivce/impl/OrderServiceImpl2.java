package com.lxx.cloud.serivce.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.google.common.collect.Lists;
import com.lxx.cloud.serivce.OrderService2;
import com.lxx.order.entity.Order;
import com.lxx.product.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl2 implements OrderService2 {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private ProductFeginClient productFeginClient;

    @SentinelResource(value = "createOrder", blockHandler = "createOrderFallback")
    @Override
    public Order createOrder(Long productId, Long userId) {
//        Product productFromRemote = getProductFromRemote(productId);
//        Product productFromRemote = getProductFromLoadBalancer(productId);
//        Product productFromRemote = getProductFromRemoteWithLoadBalancerAnnotation(productId);
        // 使用Fegin完成远程调用
        Product productFromRemote = productFeginClient.getProductById(productId);
        Order order = new Order();
        order.setId(1L);
        order.setNum(5);

        BigDecimal price = productFromRemote.getPrice();
        BigDecimal multiply = price.multiply(BigDecimal.valueOf(order.getNum()));
        order.setTotalAmount(multiply);
        order.setUserId(1001L);
        order.setNickName("");
        order.setAddress("");
        order.setProducts(Lists.newArrayList(productFromRemote));
        return order;
    }

    // 兜底回调
    public Order createOrderFallback(Long productId, Long userId, BlockException e) {
        Order order = new Order();
        order.setId(0L);
        order.setTotalAmount(new BigDecimal("0"));
        order.setUserId(userId);
        order.setNickName("未知用户");
        order.setAddress("异常信息" + e.getClass());
        order.setNum(0);
        order.setProducts(Lists.newArrayList());
        return order;
    }

    @Override
    public Product getProductFromRemote(Long productId) {
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");

        ServiceInstance serviceInstance = instances.get(0);

        String url = serviceInstance.getUri().toString() + "/product/" + productId;

        return restTemplate.getForObject(url, Product.class);
    }

    // 完成负载均衡
    @Override
    public Product getProductFromLoadBalancer(Long productId) {
        ServiceInstance choose = loadBalancer.choose("service-product");

        String url = choose.getUri().toString() + "/product/" + productId;
        log.info("get service product url:" + url);
        Product forObject = restTemplate.getForObject(url, Product.class);

        return forObject;
    }

    @Override
    public Product getProductFromRemoteWithLoadBalancerAnnotation(Long productId) {
        // 注解LoadBalancer restTemplate，会将service-product替换为IP地址
        String url = "http://service-product/product/" + productId;
        Product forObject = restTemplate.getForObject(url, Product.class);
        return forObject;
    }


}
