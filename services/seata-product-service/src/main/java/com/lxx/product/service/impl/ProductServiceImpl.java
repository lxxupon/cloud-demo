package com.lxx.product.service.impl;

import com.lxx.product.entity.Product;
import com.lxx.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(BigDecimal.valueOf(99));
        product.setName("苹果"+productId);
        product.setNum(99);
//        try {
//            TimeUnit.SECONDS.sleep(100);
//        } catch (InterruptedException e) {
//        }
        return product;
    }
}
