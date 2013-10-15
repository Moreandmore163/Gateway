/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.model.enums.user.fund;

import com.creditcloud.model.enums.BaseEnum;

/**
 *
 * @author rooseek
 */
public enum FundRecordType implements BaseEnum {

    INITIATE("初始"),
    RECHARGE("充值"),
    WITHDRAW("提现"),
    INVEST_FROZEN("投标成功，资金冻结"),
    INVEST_SETTLED("投资成功,资金已结算"),
    INVEST_FAILED("流标,投资金额返还现金账户"),
    INVEST_REPAY("投资回款"),
    LOAN("借款结算"),
    LOAN_REPAY("还款"),
    FROZEN("冻结资金"),
    RELEASE("解冻资金");

    private final String key;

    private FundRecordType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
