package com.lxx.product.controller;

import com.lxx.product.entity.Product;
import com.lxx.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "商品管理", description = "商品相关的 CRUD 操作接口")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "获取商品", description = "根据商品ID获取商品信息")
    @GetMapping("/product/{id}")
    public Product getProductById(
            @Parameter(description = "商品ID", required = true, example = "100")
            @PathVariable("id") Long productId) {
        log.info("===========load getProductById:{}", productId);
        Product prd = productService.getProductById(productId);
        return prd;
    }

}
