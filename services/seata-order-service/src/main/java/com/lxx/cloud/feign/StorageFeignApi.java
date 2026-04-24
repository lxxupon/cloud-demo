package com.lxx.cloud.feign;

import com.lxx.common.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther lxx
 * @create 2026-04-08 14:06
 */
@FeignClient(value = "seata-storage-service")
public interface StorageFeignApi {
    @Operation(summary = "扣减库存", description = "通过Feign调用库存服务扣减库存")
    @PostMapping(value = "/storage/decrease")
    ResultData decrease(
            @Parameter(description = "产品ID", required = true, example = "100") @RequestParam("productId") Long productId,
            @Parameter(description = "扣减数量", required = true, example = "5") @RequestParam("count") Integer count);
}
