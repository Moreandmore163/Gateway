/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.model;

import java.math.BigDecimal;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 用户资金
 *
 * @author rooseek
 */
public class UserFund extends BaseObject {

    @Id
    private String userId;

    @NotNull
    private User user;

    /**
     * 可用余额
     */
    @NotNull
    private BigDecimal availableAmount;

    /**
     * 冻结金额
     */
    @NotNull
    private BigDecimal frozenAmount;

    /**
     * 待收总额
     */
    @NotNull
    private BigDecimal dueInAmount;

    /**
     * 待还总额
     */
    @NotNull
    private BigDecimal dueOutAmount;

    public UserFund(String userId, User user, BigDecimal availableAmount, BigDecimal frozenAmount, BigDecimal dueInAmount, BigDecimal dueOutAmount) {
        this.userId = userId;
        this.user = user;
        this.availableAmount = availableAmount;
        this.frozenAmount = frozenAmount;
        this.dueInAmount = dueInAmount;
        this.dueOutAmount = dueOutAmount;
    }

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    public BigDecimal getDueInAmount() {
        return dueInAmount;
    }

    public BigDecimal getDueOutAmount() {
        return dueOutAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public void setDueInAmount(BigDecimal dueInAmount) {
        this.dueInAmount = dueInAmount;
    }

    public void setDueOutAmount(BigDecimal dueOutAmount) {
        this.dueOutAmount = dueOutAmount;
    }

    public UserFund() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
