/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.model.loan;

import com.creditcloud.model.BaseObject;
import com.creditcloud.model.constant.LoanConstant;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 投资的额度限制
 *
 * @author rooseek
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@XmlRootElement
public class InvestRule extends BaseObject {

    private static final long serialVersionUID = 20140102L;

    /**
     * 最小投资额
     */
    @FormParam("minAmount")
    @Min(LoanConstant.MIN_INVEST_AMOUNT)
    private int minAmount;

    /**
     * 最大投资额
     */
    @FormParam("maxAmount")
    @Max(LoanConstant.MAX_INVEST_AMOUNT)
    private int maxAmount;

    /**
     * 投资金额增量
     */
    @FormParam("stepAmount")
    @Min(LoanConstant.INVEST_AMOUNT_INCREMENT)
    private int stepAmount;
    
    public static boolean valid(InvestRule rule, int amount) {
        if (rule == null) {
            return false;
        }
        if (amount < rule.getMinAmount()
                || amount > rule.getMaxAmount()
                || (amount - rule.getMinAmount()) % rule.getStepAmount() != 0) {
            return false;
        }

        return true;
    }
}
