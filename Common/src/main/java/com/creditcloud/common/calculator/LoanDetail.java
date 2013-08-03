/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.common.calculator;

import com.creditcloud.model.BaseObject;
import com.creditcloud.model.enums.loan.RepaymentMethod;
import com.creditcloud.model.loan.Duration;
import com.creditcloud.model.loan.Repayment;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sobranie
 */
public class LoanDetail extends BaseObject {

    /**
     * 本金
     */
    private final BigDecimal principal;

    /**
     * 利息
     */
    private final BigDecimal interest;

    /**
     * 借款时间
     */
    private final Duration duration;
    
    /**
     * 还款方式
     */
    private final RepaymentMethod method;
    
    /**
     * 还款明细，包含期数
     */
    private final List<Repayment> repayments;

    public LoanDetail(BigDecimal principal,
                      BigDecimal interest, 
                      Duration duration, 
                      RepaymentMethod method) {
        this.principal = principal;
        this.interest = interest;
        this.duration = duration;
        this.method = method;
        repayments = new ArrayList<>();
    }
    
    public BigDecimal getPrincipal() {
        return principal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public Duration getDuration() {
        return duration;
    }

    public RepaymentMethod getMethod() {
        return method;
    }

    public List<Repayment> getRepayments() {
        return repayments;
    }
}
