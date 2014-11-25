/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.yeep.model.service;

import com.creditcloud.yeep.model.BaseNotification;
import com.creditcloud.yeep.enums.BizType;
import javax.validation.constraints.NotNull;
/**
 * 放款
 *  
 * @author tinglany
 */

//@Data
//@NoArgsConstructor
public class LoanNtf extends BaseNotification {
    
    //请求流水号
    @NotNull
    private String requestNo;
    
    //标的号
    @NotNull
    private String orderNo;
    
    public LoanNtf(String platformNo,
                            BizType bizType,
                            String code,
                            String message,
                            String requestNo,
                            String orderNo) {
        super(platformNo,bizType,code,message);
        this.requestNo = requestNo;
        this.orderNo = orderNo;
    }  
}
