package com.lxx.cloud.controller;

import com.lxx.cloud.service.StorageService;
import com.lxx.common.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther lxx
 * @create 2026-04-08 16:09
 */
@Tag(name = "库存管理", description = "库存相关的 CRUD 操作接口")
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @Operation(summary = "扣减库存", description = "根据产品ID扣减库存数量")
    @GetMapping("/storage/decrease")
    public ResultData decrease(
            @Parameter(description = "产品ID", required = true, example = "100")
            @RequestParam("productId") Long productId,
            @Parameter(description = "扣减数量", required = true, example = "5")
            @RequestParam("count") Integer count) {

        storageService.decrease(productId, count);
        return ResultData.success("扣减库存成功!");
    }
}

