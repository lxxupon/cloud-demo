package com.lxx.cloud.feign;

import com.lxx.common.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther lxx
 * @create 2026-04-08 14:07
 */
@FeignClient(value = "seata-account-service")
public interface AccountFeignApi {
    @Operation(summary = "扣减账户余额", description = "通过Feign调用账户服务扣减余额")
    @PostMapping("/account/decrease")
    ResultData decrease(
            @Parameter(description = "用户ID", required = true, example = "1001") @RequestParam("userId") Long userId,
            @Parameter(description = "金额", required = true, example = "50") @RequestParam("money") Long money);
}
