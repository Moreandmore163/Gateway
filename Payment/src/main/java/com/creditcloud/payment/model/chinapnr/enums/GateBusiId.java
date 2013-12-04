/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.payment.model.chinapnr.enums;

import com.creditcloud.model.enums.BaseEnum;

/**
 *
 * @author rooseek
 */
public enum GateBusiId implements BaseEnum {

    B2C("B2C网银支付"),
    B2B("B2B网银支付"),
    FPAY("快捷支付"),
    POS("POS"),
    WPAY("定向支付"),
    WH("代扣");

    private final String key;

    private GateBusiId(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
