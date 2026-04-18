package com.lxx.order.service;

import com.lxx.order.entity.Order;
import com.lxx.product.entity.Product;

public interface OrderService {
    Order createOrder(Long productId, Long userId);

    Product getProductFromRemote(Long productId);

    // 完成负载均衡
    Product getProductFromLoadBalancer(Long productId);

    Product getProductFromRemoteWithLoadBalancerAnnotation(Long productId);
}
