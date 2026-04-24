package com.lxx.cloud.controller;

import com.lxx.cloud.serivce.AccountService;
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
 * @create 2026-04-08 16:16
 */
@Tag(name = "账户管理", description = "账户相关的 CRUD 操作接口")
@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @Operation(summary = "扣减账户余额", description = "扣减账户余额")
    @GetMapping("/account/decrease")
    public ResultData decrease(@Parameter(description = "用户 ID", required = true, example = "1001")
                               @RequestParam("userId") Long userId,
                               @Parameter(description = "金额", required = true, example = "50")
                               @RequestParam("money") Long money) {
        accountService.decrease(userId, money);
        return ResultData.success("扣减账户余额成功！");
    }
}
