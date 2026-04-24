package com.lxx.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.google.common.collect.Lists;
import com.lxx.cloud.config.OrderProperties;
import com.lxx.cloud.serivce.OrderService2;
import com.lxx.common.ResultData;
import com.lxx.order.entity.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Slf4j
@Tag(name = "订单管理V2", description = "订单高级操作接口，包含Sentinel熔断降级测试")
@RestController
public class OrderController2 {

    @Autowired
    private OrderService2 orderService;

    @Value("${order.timeout}")
    private String orderTimeout;
    @Value("${order.auto-confirm}")
    private String orderAutoConfirm;

    @Autowired
    private OrderProperties orderProperties;


    @Operation(summary = "获取配置", description = "获取订单超时和自动确认配置")
    @GetMapping("/config")
    public String getConfig() {
        return "order.timeout:" + orderTimeout + ",order.auto-confirm:" + orderAutoConfirm;
    }

    @Operation(summary = "获取配置属性", description = "从配置中心获取订单配置属性")
    @GetMapping("/properties-config")
    public String getPropertiesConfig() {
        return "order.timeout:" + orderProperties.getTimeout() +
                ",order.auto-confirm:" + orderProperties.getAutoConfirm() +
                ",order.db-url:" + orderProperties.getDbUrl();
    }

    @Operation(summary = "创建订单", description = "根据产品ID和用户ID创建订单")
    @GetMapping("/create")
    public Order createOrder(
            @Parameter(description = "产品ID", required = true, example = "100") @RequestParam("productId") Long productId,
            @Parameter(description = "用户ID", required = true, example = "1001") @RequestParam("userId") Long userId) {
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
    @Operation(summary = "秒杀下单", description = "高并发秒杀场景，使用Sentinel进行熔断降级")
    @GetMapping("/seckill")
    public Order seckill(
            @Parameter(description = "产品ID", required = true, example = "100") @RequestParam("productId") Long productId,
            @Parameter(description = "用户ID", required = true, example = "1001") @RequestParam("userId") Long userId) {
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
    @Operation(summary = "读数据库", description = "测试Sentinel关联模式的读DB接口")
    @GetMapping("/read-db")
    public ResultData readDb() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return ResultData.success("read DB success...");
    }

    @Operation(summary = "写数据库", description = "测试Sentinel关联模式的写DB接口")
    @GetMapping("/write-db")
    public ResultData writeDb() {
        return ResultData.success("write DB success...");
    }

}
