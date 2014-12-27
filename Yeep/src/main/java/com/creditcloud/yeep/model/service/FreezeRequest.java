/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.yeep.model.service;
import com.creditcloud.yeep.model.UserRequest;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.StringUtils;
/**
 * 资金冻结
 * 
 * @author tinglany
 */
@XmlRootElement (name = "request")
public class FreezeRequest extends UserRequest {
  
    //冻结金额
    @NotNull
    private String amount; 
    
    //到期自动解冻
    @NotNull
    private String expired; 

    public FreezeRequest() {
    }
    
    public FreezeRequest(String platformNo,
                         String platformUserNo,
                         String requestNo,
                         String amount,
                         String expired,
                         String sign) {
        super(platformUserNo,platformNo,null,requestNo,null,null,sign);
        this.amount = amount;
        this.expired = expired;
    } 

    public String getAmount() {
        return amount;
    }

    public String getExpired() {
        return expired;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }
    
    @Override
    public String chkString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.baseChkString())
                .append(StringUtils.trimToEmpty(amount))
                .append(StringUtils.trimToEmpty(expired));
        return sb.toString();
    }    
}
