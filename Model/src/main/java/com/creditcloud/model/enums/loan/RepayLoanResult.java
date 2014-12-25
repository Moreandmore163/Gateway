package com.creditcloud.model.enums.loan;

import com.creditcloud.model.enums.BaseEnum;

/**
 * 还款结果
 *
 * @author rooseek
 */
public enum RepayLoanResult implements BaseEnum {

    SUCCESS("成功"),
    FAIL("失败"),
    INSUFFICIENT("余额不足"),
    GUARANTEE_NOT_FOUND("找不到担保账户"),
    LOAN_NOT_FOUND("找不到标的"),
    GUARANTEE_ACCOUNT_EXCEPTION("第三方托管账户异常"),
    ILLEGAL_PARAM("参数非法");

    private final String key;

    RepayLoanResult(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
