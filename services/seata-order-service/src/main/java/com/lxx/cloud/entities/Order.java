package com.lxx.cloud.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 订单实体类
 * <p>
 * 对应数据库表 t_order，用于存储订单相关信息，包括用户ID、产品ID、数量、金额和订单状态。
 * 该实体类支持分布式事务管理（Seata）。
 *
 * @author lxx
 * @version 1.0
 * @see java.io.Serializable
 * @since 2026-04-08
 */
@Schema(description = "订单实体", title = "Order")
@Table(name = "t_order")
@ToString
public class Order implements Serializable {
    /**
     * 订单ID
     * <p>
     * 主键，自增
     */
    @Schema(description = "订单ID", example = "1001", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户ID
     * <p>
     * 关联的用户标识，用于标识下单用户
     */
    @Schema(description = "用户ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "user_id")
    private Long userId;

    /**
     * 产品ID
     * <p>
     * 关联的产品标识，用于标识订单中的商品
     */
    @Schema(description = "产品ID", example = "100", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "product_id")
    private Long productId;

    /**
     * 购买数量
     * <p>
     * 订单中产品的购买数量
     */
    @Schema(description = "购买数量", example = "5", minimum = "1", maximum = "999", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer count;

    /**
     * 订单金额
     * <p>
     * 订单总金额，单位为分
     */
    @Schema(description = "订单金额（单位：分）", example = "9900", minimum = "0", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long money;

    /**
     * 订单状态
     * <p>
     * 表示订单的当前状态：
     * <ul>
     *   <li>0: 创建中 - 订单正在创建过程中</li>
     *   <li>1: 已完结 - 订单已完成</li>
     * </ul>
     */
    @Schema(description = "订单状态 0: 创建中, 1: 已完结", example = "0", allowableValues = {"0", "1"}
    )
    private Integer status;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return userId - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取产品id
     *
     * @return productId - 产品id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 获取数量
     *
     * @return count - 数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置数量
     *
     * @param count 数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取金额
     *
     * @return money - 金额
     */
    public Long getMoney() {
        return money;
    }

    /**
     * 设置金额
     *
     * @param money 金额
     */
    public void setMoney(Long money) {
        this.money = money;
    }

    /**
     * 获取订单状态: 0:创建中; 1:已完结
     *
     * @return status - 订单状态: 0:创建中; 1:已完结
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置订单状态: 0:创建中; 1:已完结
     *
     * @param status 订单状态: 0:创建中; 1:已完结
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}