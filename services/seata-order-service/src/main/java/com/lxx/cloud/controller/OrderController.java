package com.lxx.cloud.controller;

import com.lxx.cloud.entities.Order;
import com.lxx.cloud.serivce.OrderService;
import com.lxx.common.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther lxx
 * @create 2026-04-08 15:56
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public ResultData create(Order order) {
        orderService.create(order);
        return ResultData.success(order);
    }
}
