package com.lxx.cloud.feign.fallback;
import java.math.BigDecimal;

import com.lxx.cloud.feign.ProductFeginClient;
import com.lxx.product.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description: feign客户端,兜底实现
 */
@Slf4j
@Component
public class ProductFeginClientFallBack implements ProductFeginClient {


    @Override
    public Product getProductById(Long id) {
        log.info("fegin 查询产品服务，兜底回调方法。。。。。。。");
        Product product = new Product();
        product.setId(9999999L);
        product.setPrice(new BigDecimal("99999"));
        product.setName("22222");
        product.setNum(9999);

        return product;
    }
}
