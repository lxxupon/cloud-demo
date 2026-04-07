package com.lxx.order.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class Order implements Serializable {
    private Long id;
    private BigDecimal totalAmount ;
    private Long userId;
    private String nickName;
    private String address;
    private Integer num;
    private List<Object> products;
}
