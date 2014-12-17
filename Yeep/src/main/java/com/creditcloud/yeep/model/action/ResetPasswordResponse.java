/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.yeep.model.action;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.creditcloud.yeep.model.BaseResponse;
import com.creditcloud.yeep.enums.BizType;
import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author kakaci
 */
@Data
@NoArgsConstructor
public class ResetPasswordResponse extends BaseResponse{
    /**
     * 固定值：RESET_PASSWORD
     */
    @NotNull
    private BizType service;
    
   /**
    * 请求流水号
    */
    @NotNull
    private String requestNo;

    public ResetPasswordResponse(String platformNo,
                                 String code,
                                 BizType service,
                                 String requestNo,
                                 String description,
                                 String sign) {
        super(platformNo, code, description,sign);
        this.service = service;
        this.requestNo=requestNo;
    }
    
    @Override
    public String chkString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.baseChkString())
                .append(StringUtils.trimToEmpty(requestNo));
        return sb.toString();
    }
}
