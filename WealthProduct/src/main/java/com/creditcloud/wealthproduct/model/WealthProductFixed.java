/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.creditcloud.wealthproduct.model;

import com.creditcloud.model.BaseObject;
import com.creditcloud.model.enums.loan.RepaymentMethod;
import com.creditcloud.wealthproduct.enums.RateLevelType;
import com.creditcloud.wealthproduct.enums.ReturnMethod;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 固定收益类理财产品
 * 
 * @author suetming <suetming.ma at creditcloud.com>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class WealthProductFixed extends BaseObject {

    /**
     * 产品ID
     * 
     * @return
     */
    private String productId;

    /**
     * 理财产品
     * 
     * @return
     */
    @NotNull
    private WealthProduct product;
 
    /**
     * 还款方式
     * 
     * @return
     */
    @NotNull
    private RepaymentMethod repayMethod;
    
    /**
     * 收益返还方式
     * 
     * @return
     */
    @NotNull
    private ReturnMethod returnMethod;
    
    /**
     * 利率档位类型
     * 
     * @return
     */
    @NotNull
    private RateLevelType rateLevelType;
    
    /**
     * 利率类型
     * 
     * @return
     */
    @NotNull
    @Size(min = 1)
    private List<WealthProductRate> rates;
}
