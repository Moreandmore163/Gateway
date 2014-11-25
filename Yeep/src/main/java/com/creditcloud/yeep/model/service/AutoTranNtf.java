/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.yeep.model.service;
import com.creditcloud.yeep.enums.BizType;
import javax.validation.constraints.NotNull;
import com.creditcloud.yeep.model.BaseNotification;

/**
 * 自动投标
 * 
 * @author tinglany
 */

//@Data
//@NoArgsConstructor
public class AutoTranNtf extends BaseNotification {
    
    //请求流水号
    @NotNull
    private String requestNo;
    
    public AutoTranNtf(String platformNo,
                       BizType bizType,
                       String code,
                       String message,
                       String requestNo) {
        super(platformNo,bizType,code,message);
        this.requestNo = requestNo;
    }   
}
