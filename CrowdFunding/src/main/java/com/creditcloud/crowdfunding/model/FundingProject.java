/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.crowdfunding.model;

import com.creditcloud.crowdfunding.enums.ProjectCategory;
import com.creditcloud.crowdfunding.enums.ProjectStatus;
import com.creditcloud.model.BaseObject;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author rooseek
 */
@XmlRootElement
@Data
@NoArgsConstructor
public class FundingProject extends BaseObject {

    private static final long serialVersionUID = 20140922L;

    private String id;

    @NotNull
    private String title;

    private ProjectStatus status;

    /**
     * project proposer
     */
    @NotNull
    private String userId;

    /**
     * goal amount
     */
    @NotNull
    private BigDecimal goalAmount;

    /**
     * actual amount raised
     */
    @NotNull
    private BigDecimal raiseAmount;

    /**
     * raised number
     */
    @NotNull
    private int raiseNumber;

    private Date openTime;

    private Date finishTime;

    /**
     * time unit:hour
     */
    @NotNull
    private int timeOut;

    /**
     * video url
     */
    private String videoUrl;

    @NotNull
    private String introduction;

    private String detail;

    private String location;

    private ProjectCategory category;

    private int favorite;

    /**
     * amount already loaned
     */
    private BigDecimal loanAmount;
    
    /**
     * project without reward, reward is mandatory most of the time
     */
    private boolean noReward;

    public FundingProject(String id,
                          String title,
                          ProjectStatus status,
                          String userId,
                          BigDecimal goalAmount,
                          int timeOut,
                          Date openTime,
                          Date finishTime,
                          String videoUrl,
                          String introduction,
                          String detail,
                          String location) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.userId = userId;
        this.goalAmount = goalAmount;
        this.timeOut = timeOut;
        this.openTime = openTime;
        this.finishTime = finishTime;
        this.videoUrl = videoUrl;
        this.introduction = introduction;
        this.detail = detail;
        this.location = location;
    }

    public BigDecimal getLoanAmont() {
        return loanAmount == null ? BigDecimal.ZERO : loanAmount;
    }
}
