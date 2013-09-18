/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.model.loan;

import com.creditcloud.model.BaseObject;
import com.creditcloud.model.User;
import com.creditcloud.model.constant.LoanConstant;
import com.creditcloud.model.constraints.IncrementalInteger;
import com.creditcloud.model.enums.Source;
import com.creditcloud.model.enums.loan.LoanRequestStatus;
import com.creditcloud.model.enums.loan.RepaymentMethod;
import com.creditcloud.model.enums.loan.LoanPurpose;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sobranie
 */
@XmlRootElement
public class LoanRequest extends BaseObject {

    private static final long serialVersionUID = 20130917L;

    /**
     * LoanRequest Id
     */
    @NotNull
    @XmlElement(name = "id")
    private String id;

    /**
     * 用户ID
     */
    @NotNull
    @XmlElement(name = "user")
    private User user;

    /**
     * title
     */
    @NotNull
    @Size(min = 4, max = 60)
    @XmlElement(name = "title")
    private String title;

    /**
     * 目的
     */
    @NotNull
    @XmlElement(name = "purpose")
    private LoanPurpose purpose;

    /**
     * 金额
     */
    @NotNull
    @IncrementalInteger(min = LoanConstant.MIN_LOAN_AMOUNT,
                        increment = LoanConstant.LOAN_AMOUNT_INCREMENT,
                        max = LoanConstant.MAX_LOAN_AMOUNT,
                        groups = Default.class)
    @XmlElement(name = "amount")
    private int amount;

    /**
     * 期限
     */
    @NotNull
    @XmlElement(name = "duration")
    private Duration duration;

    /**
     * 年化利率（万分之几）
     */
    @NotNull
    @IncrementalInteger(min = LoanConstant.MIN_LOAN_RATE,
                        increment = 1,
                        max = LoanConstant.MAX_LOAN_RATE,
                        groups = Default.class)
    @XmlElement(name = "rate")
    private int rate;

    /**
     * 偿还方法
     */
    @NotNull
    @XmlElement(name = "method")
    private RepaymentMethod method;

    /**
     * 描述
     */
    @Size(max = 500)
    @XmlElement(name = "description")
    private String description;

    /**
     * 状态(初始状态为：UNASSIGNED)
     */
    @NotNull
    @XmlElement(name = "status")
    private LoanRequestStatus status;

    /**
     * 提交时间
     */
    @NotNull
    @Past
    @XmlElement(name = "timeSubmit")
    private Date timeSubmit;

    @XmlElement(name = "mortgaged")
    private boolean mortgaged;
    
    @XmlElement(name="source")
    private Source source;

    public LoanRequest() {
    }

    /**
     *
     * @param id LoanRequest Id, nullable
     * @param user 用户
     * @param title title
     * @param purpose 目的
     * @param amount 金额
     * @param duration 期限
     * @param rate 年化利率（万分之几）
     * @param method 偿还方法
     * @param description 描述
     * @param status 状态(初始状态为：UNASSIGNED)
     * @param timeSubmit 提交时间
     */
    public LoanRequest(String id,
                       User user,
                       String title,
                       LoanPurpose purpose,
                       int amount,
                       Duration duration,
                       int rate,
                       RepaymentMethod method,
                       String description,
                       LoanRequestStatus status,
                       Date timeSubmit,
                       boolean mortgaged,
                       Source source) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.purpose = purpose;
        this.amount = amount;
        this.duration = duration;
        this.rate = rate;
        this.method = method;
        this.description = description;
        this.status = status;
        this.timeSubmit = timeSubmit;
        this.mortgaged = mortgaged;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public LoanPurpose getPurpose() {
        return purpose;
    }

    public int getAmount() {
        return amount;
    }

    public Duration getDuration() {
        return duration;
    }

    public int getRate() {
        return rate;
    }

    public RepaymentMethod getMethod() {
        return method;
    }

    public String getDescription() {
        return description;
    }

    public LoanRequestStatus getStatus() {
        return status;
    }

    public void setStatus(LoanRequestStatus status) {
        this.status = status;
    }

    public Date getTimeSubmit() {
        return timeSubmit;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPurpose(LoanPurpose purpose) {
        this.purpose = purpose;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setMethod(RepaymentMethod method) {
        this.method = method;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimeSubmit(Date timeSubmit) {
        this.timeSubmit = timeSubmit;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
