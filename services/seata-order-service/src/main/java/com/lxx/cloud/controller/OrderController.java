package com.lxx.cloud.controller;

import com.lxx.cloud.entities.Order;
import com.lxx.cloud.serivce.OrderService;
import com.lxx.common.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther lxx
 * @create 2026-04-08 15:56
 */
@Tag(name = "订单管理", description = "订单相关的 CRUD 操作接口")
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     * <p>
     * 该方法用于创建新的订单，包含用户信息、产品信息、数量和金额等。
     * 创建成功后会返回完整的订单信息。
     *
     * @param order 订单对象，包含以下信息：
     *              - userId: 用户ID
     *              - productId: 产品ID
     *              - count: 购买数量
     *              - money: 订单金额（单位：分）
     *              - status: 订单状态（0:创建中; 1:已完结）
     * @return ResultData 包含创建成功的订单信息
     * @see com.lxx.cloud.entities.Order
     */
    @Operation(
        summary = "创建订单", 
        description = "创建新订单，包含用户、产品、数量和金额等信息。订单创建后状态为'创建中'。",
        tags = {"订单管理"}
    )
    @GetMapping("/order/create")
    public ResultData create(
            @Parameter(description = "订单信息对象", required = true) Order order) {
        orderService.create(order);
        return ResultData.success(order);
    }
}
