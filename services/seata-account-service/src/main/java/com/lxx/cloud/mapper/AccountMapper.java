package com.lxx.cloud.mapper;

import com.lxx.cloud.entities.Account;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @auther lxx
 * @create 2026-04-08 16:14
 */

public interface AccountMapper extends Mapper<Account> {

    /**
     * @param userId
     * @param money  本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}

