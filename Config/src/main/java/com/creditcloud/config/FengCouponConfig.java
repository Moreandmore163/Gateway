/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.config;

import com.creditcloud.fund.model.enums.CouponType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author caojiadong
 */
@Data
@NoArgsConstructor
@XmlRootElement(name = "FengCouponConfig")
@XmlAccessorType(XmlAccessType.FIELD)
public class FengCouponConfig extends BaseConfig {
    private static final long serialVersionUID = 20150325L;

    public static final String CONFIG_NAME = "FengCouponConfig";

    @XmlElement(name="FengCoupon",required = false)
    private FengCoupon[] couponList;
    
    public FengCoupon getRegisterCoupon(){
        for(FengCoupon coupon : couponList){
            if(coupon.getCouponType() == CouponType.REGISTER_COUPON){
                return coupon;
            }
        }
        return null;
    }
    
    public List<FengCoupon> getCouponByEventId(String eventId){
        List<FengCoupon> coupons = new ArrayList<>();
        for(FengCoupon coupon : couponList){
            if(coupon.getEventId().equals(eventId)){
                coupons.add(coupon);
            }
        }
        return coupons;
    }
    
    public List<FengCoupon> getCouponByType(CouponType type){
        List<FengCoupon> coupons = new ArrayList<>();
        for(FengCoupon coupon : couponList){
            if(coupon.getCouponType() == type){
                coupons.add(coupon);
            }
        }
        return coupons;
    }
    
    public FengCoupon getCoupon(String couponId){
        for(FengCoupon coupon : couponList){
            if(coupon.getCouponId().equals(couponId)){
                return coupon;
            }
        }
        return null;
    }
}
