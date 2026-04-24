package com.lxx.product.entity;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "商品实体", title = "Product")
@Data
public class Product {
    @Schema(description = "商品ID", example = "100", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "商品价格", example = "99.99")
    private BigDecimal price;

    @Schema(description = "商品名称", example = "iPhone 15")
    private String name;

    @Schema(description = "商品数量", example = "50")
    private int num;
}
