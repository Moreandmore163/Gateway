/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.payment.model;

import java.math.RoundingMode;

/**
 * 汇付天下支付接口常量
 *
 * @author sobranie
 */
public interface PnRConstant {

    /**
     * 默认的Version
     */
    String Version = "10";

    /**
     * 默认的证件类型，身份证
     */
    String IdType = "00";

    /**
     * 默认的字符编码，固定使用UTF-8
     */
    String CharSet = "UTF-8";

    /**
     * 每页最大记录数
     */
    int MAX_PAGE_SIZE = 1000;

    RoundingMode ROUNDING_MODE = RoundingMode.CEILING;

    /**
     * 成功的返回码
     */
    String SUCCESS_CODE = "000";

    /**
     * 不是汇付定义的返回值，用于表示在PaymentAccount中未找到user的汇付账号
     */
    String ACCOUNT_NOT_FOUND_CODE = "account.not.found";

    String ACCOUNT_NOT_FOUND_DESC = "未找到支付账号";

}
