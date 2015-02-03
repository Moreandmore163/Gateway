/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.yeep.model;

import com.creditcloud.model.BaseObject;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tinglany
 */
@XmlRootElement
public class BorrowerDetail extends BaseObject {
    private static final long serialVersionUID = 20141229L;
    
    /**
     * 借款人平台用户编号
     */
    @NotNull
    @Size(max = 16)
    private String targetPmUserNo;
    
    /**
     * 借款金额
     */
    @NotNull
    @Size(max = 12)
    private BigDecimal BorrowerAmt;
    
    /**
     * 借款手续费率
     */
    @Size(max = 6)
    private BigDecimal BorrowerRate;

    public BorrowerDetail() {
    }

    public BorrowerDetail(String targetPmUserNo, BigDecimal BorrowerAmt, BigDecimal BorrowerRate) {
        this.targetPmUserNo = targetPmUserNo;
        this.BorrowerAmt = BorrowerAmt;
        this.BorrowerRate = BorrowerRate;
    }

    public String getTargetPmUserNo() {
        return targetPmUserNo;
    }

    public BigDecimal getBorrowerAmt() {
        return BorrowerAmt;
    }

    public BigDecimal getBorrowerRate() {
        return BorrowerRate;
    }

    public void setTargetPmUserNo(String targetPmUserNo) {
        this.targetPmUserNo = targetPmUserNo;
    }

    public void setBorrowerAmt(BigDecimal BorrowerAmt) {
        this.BorrowerAmt = BorrowerAmt;
    }

    public void setBorrowerRate(BigDecimal BorrowerRate) {
        this.BorrowerRate = BorrowerRate;
    }
    
    
    
}
