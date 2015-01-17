/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.coupon.model;

import com.creditcloud.model.BaseObject;
import com.creditcloud.model.constraints.UUID;
import com.creditcloud.model.misc.RealmEntity;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 一个批次的奖券，属于同一个类型.
 * 
 * 奖券的发行按照批次来
 * 
 * @author sobranie
 */
@Data
@AllArgsConstructor
public class CouponPackage extends BaseObject {
    
    private static final long serialVersionUID = 20150117L;

    @UUID
    @NotNull
    private String id;
    
    /**
     * 奖券类型
     */
    @NotNull
    private CouponType type;
    
    /**
     * 显示用名称
     */
    @NotNull
    private String name;
    
    /**
     * 详情介绍
     */
    private String description;
    
    /**
     * 发行总数，不是总值，而是奖券的总张数
     */
    @Min(1)
    private int totalCount;
    
    /**
     * 票面价值.
     * 
     * 对于现金券，表示其兑换现金的额度.
     * 
     * 对于加息券，表示其提高利息的基点数（万分之一，参考rate）
     */
    @Min(0)
    private int parValue;
    
    /**
     * 发行人.
     * 
     * 一般是平台直接发行，也可以支持企业甚至个人直接发行.
     * 
     * 奖券的兑换由发行人账户兑现
     * 
     */
    @NotNull
    private RealmEntity issuer;

    /**
     * 发行时间
     */
    @NotNull
    private Date timeIssued;
    
    /**
     * 生效时间.
     * 
     * 生效时间后才可以进行兑换等操作
     * 
     * null表示即时生效
     */
    private Date timeStart;
    
    /**
     * 过期时间，该批次的所有奖券都有同样的过期时间.
     * 
     * null表示永不过期
     */
    private Date timeExpire;
    
    /**
     * 该批奖券在前台显示的名字
     */
    @NotNull
    private String displayName;
}
