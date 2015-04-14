/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.fund.model;

import com.creditcloud.fund.model.enums.CouponType;
import com.creditcloud.fund.model.enums.ExpireMode;
import com.creditcloud.model.BaseObject;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 活动奖品
 *
 * @author zaishu.ye@fengjr.com
 */
@Data

@NoArgsConstructor
public class EventPrize extends BaseObject {

    private static final long serialVersionUID = 20140415L;
    private String id;
    private String eventNo;
    private String prizeNo;
    private String prizeName;
    private CouponType prizeType;//奖品类型
    private BigDecimal amount;//金额
    private Integer inventory;//剩余库存
    private boolean asDefault;
    private ExpireMode expireMode;//过期方式
    private String expireValue;//过期值
    private boolean valid;

    public EventPrize(String id,
                      String eventNo,
                      String prizeNo,
                      String prizeName,
                      CouponType prizeType,
                      BigDecimal amount,
                      Integer inventory,
                      boolean asDefault,
                      ExpireMode expireMode,
                      String expireValue,
                      boolean valid) {
        this.id = id;
        this.eventNo = eventNo;
        this.prizeNo = prizeNo;
        this.prizeName = prizeName;
        this.prizeType = prizeType;
        this.amount = amount;
        this.inventory = inventory;
        this.asDefault = asDefault;
        this.expireMode = expireMode;
        this.expireValue = expireValue;
        this.valid = valid;
    }
}
