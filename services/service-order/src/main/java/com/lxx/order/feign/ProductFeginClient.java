package com.lxx.order.feign;

import com.lxx.order.feign.fallback.ProductFeginClientFallBack;
import com.lxx.product.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "service-product",
//        path = "/api/product",
        fallback = ProductFeginClientFallBack.class) // fegin客户端,自动负载均衡
public interface ProductFeginClient {

    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable("id") Long id);
}
