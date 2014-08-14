/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.creditcloud.config;

import com.creditcloud.model.enums.misc.Bank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author kdliu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "UmpSubAccount")
@XmlAccessorType(XmlAccessType.FIELD)
public class UmpSubAccount {

    @XmlElement(required = true)
    private String merId;
    
    @XmlElement(required = true)
    private String accountId;
    
    @XmlElement(required = true)
    private String payType;
    
    @XmlElement(required = true)
    private Bank bank;
}
