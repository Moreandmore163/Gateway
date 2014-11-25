/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.yeep.model.action;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

import com.creditcloud.yeep.enums.FeeModel;
import com.creditcloud.yeep.model.UserRequest;

/**
 *
 * @author sobranie
 */
@Data
@NoArgsConstructor
public class RechargeAccountRequest extends UserRequest {

    /**
     * 平台用户编号
     */
    @NotNull
    private String platformUserNo;

    /**
     * 请求流水号
     */
    @NotNull
    private String requestNo;

    /**
     * 充值金额，如果不传则有用户填写充值金额
     */
    private String amount;

    /**
     * 费率模式，固定值PLATFORM
     */
    @NotNull
    private FeeModel feeMode;

    public RechargeAccountRequest(String platformNo,
                                  String platformUserNo,
                                  String requestNo,
                                  String amount,
                                  FeeModel feeMode,
                                  String callbackUrl,
                                  String notifyUrl,
                                  String sign) {
        super(platformUserNo, platformNo, callbackUrl, notifyUrl, sign);
        this.requestNo = requestNo;
        this.amount = amount;
        this.feeMode = feeMode;
    }
}
