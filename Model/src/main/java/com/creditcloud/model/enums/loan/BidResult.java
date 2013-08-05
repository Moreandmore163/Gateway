/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.model.enums.loan;

import com.creditcloud.model.enums.BaseEnum;

/**
 *
 * @author rooseek
 */
public enum BidResult implements BaseEnum {

    SUCCESSFUL("投标成功，资金被冻结"),
    BID_NOT_OPEN("贷款标没有开始,或者已经结束"),
    BALANCE_INSUFFICIENT("账户可用余额不足"),
    LOAN_INSUFFICIENT("可贷余额不足"),
    FREEZE_FAILED("冻结用户账户余额失败"),
    FAILED("其他原因失败"),;

    private final String key;

    private BidResult(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
