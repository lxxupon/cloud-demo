package com.lxx.cloud.service;

/**
 * @auther lxx
 * @create 2026-04-08 16:08
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
