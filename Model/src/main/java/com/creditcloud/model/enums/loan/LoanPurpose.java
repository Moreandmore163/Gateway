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
public enum LoanPurpose implements BaseEnum {

    SHORTTERM("短期周转"),
    PERSONAL("个人消费"),
    INVESTMENT("投资创业"),
    CAR("购车借款"),
    HOUSE("购房借款"),
    OTHER("其它借款");

    private final String key;

    private LoanPurpose(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
