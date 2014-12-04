/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.yeep.model;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author rooseek
 */
@Data
@NoArgsConstructor
@XmlType(propOrder = { "platformUserNo", "requestNo"})
public class UserRequest extends BaseRequest {

    /**
     *  平台用户编号
     * 
     */
    @NotNull
    @XmlTransient
    private String platformUserNo;
    
    /**
     *  请求流水号
     * 
     */
 //   @XmlElement 
    @XmlTransient
    private String requestNo;

    public UserRequest(String platformUserNo,
                       String platformNo,
                       String service,
                       String requestNo,
                       String callbackUrl,
                       String notifyUrl) {
        super(platformNo, service, callbackUrl, notifyUrl);
        this.platformUserNo = platformUserNo;
        this.requestNo = requestNo;
    }
}
