package com.lxx.cloud.serivce;

import com.lxx.cloud.entities.Order;

/**
 * @auther lxx
 * @create 2026-04-08 15:39
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
