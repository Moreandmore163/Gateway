/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.config;

import com.creditcloud.fund.model.enums.CouponType;
import com.creditcloud.model.BaseObject;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author caojiadong
 */
@Data
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FengCoupon extends BaseObject {
    
    private static final long serialVersionUID = 20150325L;
    
    @XmlElement(required = false)
    private String eventNumber;
    
    @XmlElement(required = false)
    private String couponId;
    
    @XmlElement(required = false)
    private CouponType couponType;
    
    @XmlElement(required = false)
    private String couponName;
    
    @XmlElement(required = false)
    private BigDecimal amount;

    @XmlElement(required = true)
    private String limitType;
    
    @XmlElement(required = false)
    private BigDecimal amountLimit;

    @XmlElement(required = false)
    private BigDecimal rateLimit;
    
    @XmlElement(required = false)
    private Integer period;
        
    @XmlElement(required = false)
    private String description;
            
    @XmlElement(required = false)
    private Integer useLimit;

    @XmlElement(required = false)
    private String preStart;

    @XmlElement(required = false)
    private String preEnd;
}
