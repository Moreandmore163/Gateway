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
import javax.ws.rs.FormParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 一个批次的奖券，属于同一个类型.
 *
 * 奖券的发行按照批次来
 *
 * @author sobranie
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponPackage extends BaseObject {

    private static final long serialVersionUID = 20150117L;

    @FormParam("id")
    @UUID
    @NotNull
    private String id;

    /**
     * 奖券类型
     */
    @FormParam("type")
    @NotNull
    private CouponType type;

    /**
     * 后台显示用名称
     */
    @FormParam("name")
    @NotNull
    private String name;

    /**
     * 该批奖券在前台显示的名字
     */
    @FormParam("displayName")
    @NotNull
    private String displayName;

    /**
     * 详情介绍
     */
    @FormParam("description")
    private String description;

    /**
     * 发行总数，不是总值，而是奖券的总张数
     */
    @FormParam("totalCount")
    @Min(1)
    private int totalCount;

    /**
     * 票面价值.
     *
     * 对于现金券，表示其兑换现金的额度.<br/>
     * 
     * 对于增值券，表示其可以虚拟的本金量.<br/>
     *
     * 对于加息券，表示其提高利息的基点数（万分之一，参考rate）.<br/>
     * 
     * 对于返现券，表示满足投资要求后平台直接返现的金额.
     */
    @FormParam("parValue")
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
     * 最小投资门槛，当奖券与投资挂钩时要求的最小有效投资额.
     * 
     * 如果用户绑定的Invest金额不时无法使用该奖券
     */
    @FormParam("minimumInvest")
    @Min(0)
    private int minimumInvest;

}
