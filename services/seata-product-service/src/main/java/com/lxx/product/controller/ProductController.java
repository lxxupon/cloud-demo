package com.lxx.product.controller;

import com.lxx.product.entity.Product;
import com.lxx.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") Long productId) {
        log.info("===========load getProductById:{}", productId);
        Product prd = productService.getProductById(productId);
        return prd;
    }

}
