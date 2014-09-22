/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.crowdfunding.model;

import com.creditcloud.model.BaseObject;
import com.creditcloud.model.enums.loan.InvestStatus;
import java.math.BigDecimal;
import java.util.Date;
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
public class FundingInvest extends BaseObject {

    private static final long serialVersionUID = 20140922L;

    private String id;

    /**
     * 項目
     */
    private String projectId;

    private InvestStatus status;

    /**
     * 投资/支持金额
     */
    private BigDecimal amount;

    /**
     * 投资人
     */
    private String userId;

    /**
     * 留言
     */
    private String message;

    private Date timeRecorded;

}
