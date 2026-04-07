package com.lxx.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.google.common.collect.Lists;
import com.lxx.common.R;
import com.lxx.order.config.OrderProperties;
import com.lxx.order.entity.Order;
import com.lxx.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
//@RefreshScope
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${order.timeout}")
    private String orderTimeout;
    @Value("${order.auto-confirm}")
    private String orderAutoConfirm;

    @Autowired
    private OrderProperties orderProperties;


    @GetMapping("/config")
    public String getConfig() {
        return "order.timeout:" + orderTimeout + ",order.auto-confirm:" + orderAutoConfirm;
    }

    @GetMapping("/properties-config")
    public String getPropertiesConfig() {
        return "order.timeout:" + orderProperties.getTimeout() +
                ",order.auto-confirm:" + orderProperties.getAutoConfirm() +
                ",order.db-url:" + orderProperties.getDbUrl();
    }

    @GetMapping("/create")
    public Order createOrder(@RequestParam("productId") Long productId,
                             @RequestParam("userId") Long userId) {
        return orderService.createOrder(productId, userId);
    }

    /**
     * blockHandler只能处理BlockException
     * fallback可以处理所有异常
     *
     * @param productId
     * @param userId
     * @return
     */
    @SentinelResource(value = "seckill-order", fallback = "seckillOrderFallback")

//    @SentinelResource(value = "seckill-order", blockHandler = "seckillOrderFallback")
    @GetMapping("/seckill")
    public Order seckill(@RequestParam("productId") Long productId,
                         @RequestParam("userId") Long userId) {
        Order order = orderService.createOrder(productId, userId);
        order.setId(Long.MIN_VALUE);
        return order;
    }

    public Order seckillOrderFallback(Long productId, Long userId, Throwable e) {
        log.info("seckill 兜底回调了。。。");
        Order order1 = new Order();
        order1.setId(0L);
        order1.setTotalAmount(new BigDecimal("0"));
        order1.setUserId(userId);
        order1.setNickName("");
        order1.setAddress("");
        order1.setNum(0);
        order1.setProducts(Lists.newArrayList(productId));
        return order1;
    }

    // 测试sentinel-流量规则-流控模式-关联模式
    @GetMapping("/read-db")
    public R readDb() {
        return R.ok("read DB success...");
    }

    @GetMapping("/write-db")
    public R writeDb() {
        return R.ok("write DB success...");
    }

}
