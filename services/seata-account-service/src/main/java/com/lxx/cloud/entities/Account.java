package com.lxx.cloud.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @auther lxx
 * @create 2026-04-08 16:13
 */
@Schema(description = "账户实体", title = "Account")
@Table(name = "t_account")
@ToString
public class Account implements Serializable {
    /**
     * id
     */
    @Schema(description = "账户ID", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户id
     */
    @Schema(description = "用户ID", example = "1001", requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "user_id")
    private Long userId;

    /**
     * 总额度
     */
    @Schema(description = "总额度", example = "100000")
    private Long total;

    /**
     * 已用余额
     */
    @Schema(description = "已用余额", example = "5000")
    private Long used;

    /**
     * 剩余可用额度
     */
    @Schema(description = "剩余可用额度", example = "95000")
    private Long residue;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取总额度
     *
     * @return total - 总额度
     */
    public Long getTotal() {
        return total;
    }

    /**
     * 设置总额度
     *
     * @param total 总额度
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * 获取已用余额
     *
     * @return used - 已用余额
     */
    public Long getUsed() {
        return used;
    }

    /**
     * 设置已用余额
     *
     * @param used 已用余额
     */
    public void setUsed(Long used) {
        this.used = used;
    }

    /**
     * 获取剩余可用额度
     *
     * @return residue - 剩余可用额度
     */
    public Long getResidue() {
        return residue;
    }

    /**
     * 设置剩余可用额度
     *
     * @param residue 剩余可用额度
     */
    public void setResidue(Long residue) {
        this.residue = residue;
    }
}

