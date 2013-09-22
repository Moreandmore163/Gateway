/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.model.loan;

import com.creditcloud.model.BaseObject;
import com.creditcloud.model.constant.LoanConstant;
import com.creditcloud.model.constraints.IncrementalInteger;
import com.creditcloud.model.enums.loan.LoanStatus;
import com.creditcloud.model.enums.loan.RepaymentMethod;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sobranie
 */
@XmlRootElement
public class Loan extends BaseObject implements Investable {

    private static final long serialVersionUID = 20130918L;

    /**
     * UUID
     */
    @NotNull
    private String id;

    private String title;

    @Min(1)
    private int ordinal;

    @IncrementalInteger(min = LoanConstant.MIN_LOAN_AMOUNT,
                        increment = LoanConstant.LOAN_AMOUNT_INCREMENT,
                        max = LoanConstant.MAX_LOAN_AMOUNT,
                        groups = Default.class)
    private int amount;

    @NotNull
    private Duration duration;

    /**
     * 开放募集时间，单位：小时 timeout = 24 就是募集期为1天 最长3天
     */
    @IncrementalInteger(min = LoanConstant.MIN_LOAN_TIME_OUT,
                        increment = 1,
                        max = LoanConstant.MAX_LOAN_TIME_OUT,
                        groups = Default.class)
    private int timeout;

    @NotNull
    private LoanRequest loanRequest;

    /**
     * 开启投标时间
     */
    private Date timeOpen;

    /**
     * 满标时间
     */
    private Date timeFinished;

    /**
     * 有无抵押
     */
    private boolean mortgaged;

    /**
     * 投标数
     */
    private int bidNumber;

    @NotNull
    private LoanStatus status;

    public Loan() {
    }

    public Loan(String id,
                String title,
                int ordinal,
                int amount,
                Duration duration,
                int timeout,
                LoanStatus status,
                LoanRequest loanRequest,
                Date timeOpen,
                Date timeFinished,
                boolean mortgaged,
                int bidNumber) {
        this.id = id;
        this.title = title;
        this.ordinal = ordinal;
        this.amount = amount;
        this.duration = duration;
        this.timeout = timeout;
        this.status = status;
        this.loanRequest = loanRequest;
        this.timeOpen = timeOpen;
        this.timeFinished = timeFinished;
        this.mortgaged = mortgaged;
        this.bidNumber = bidNumber;
    }

    @Override
    public String getId() {
        return id;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public int getAmount() {
        return amount;
    }

    public int getTimeout() {
        return timeout;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public LoanRequest getLoanRequest() {
        return loanRequest;
    }

    public Date getTimeOpen() {
        return timeOpen;
    }

    public Date getTimeFinished() {
        return timeFinished;
    }

    public void setTimeFinished(Date timeFinished) {
        this.timeFinished = timeFinished;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    public int getBidNumber() {
        return bidNumber;
    }

    public void setBidNumber(int bidNumber) {
        this.bidNumber = bidNumber;
    }

    @Override
    public int getRate() {
        return loanRequest.getRate();
    }

    @Override
    public RepaymentMethod getMethod() {
        return loanRequest.getMethod();
    }

    public String getTitle() {
        return title;
    }
}