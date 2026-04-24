package com.lxx.cloud.feign;

import com.lxx.cloud.feign.fallback.ProductFeginClientFallBack;
import com.lxx.product.entity.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "service-product",
        fallback = ProductFeginClientFallBack.class)
public interface ProductFeginClient {

    @Operation(summary = "获取商品", description = "通过Feign调用产品服务获取商品信息")
    @GetMapping("/product/{id}")
    Product getProductById(@Parameter(description = "商品ID", required = true, example = "100") @PathVariable("id") Long id);
}
