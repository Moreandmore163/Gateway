/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.coupon.api;

import com.creditcloud.coupon.model.CouponPackage;
import com.creditcloud.coupon.model.CouponPlacement;
import com.creditcloud.coupon.model.CouponStatus;
import com.creditcloud.coupon.model.CouponType;
import com.creditcloud.model.criteria.PageInfo;
import com.creditcloud.model.misc.PagedResult;
import javax.ejb.Remote;

/**
 * 与奖券相关的只读查询接口
 *
 * @author sobranie
 */
@Remote
public interface CouponQueryService {
    
    /**
     * 根据Id获取奖券包
     * 
     * @param clientCode
     * @param id
     * @return 
     */
     public CouponPackage findCouponPackagebyId(String clientCode, String id);

    /**
     * 分页列出所有的奖券包
     * 
     * @param clientCode
     * @param pageInfo
     * @return 
     */
    PagedResult<CouponPackage> listCouponPackage(String clientCode, PageInfo pageInfo);
    
    /**
     * 分页列出某个奖券包的所有分配情况.
     * 
     * @param clientCode
     * @param packageId
     * @param pageInfo
     * @param statusList 传入一个参数可以当做分类列出使用
     * @return 
     */
    PagedResult<CouponPlacement> listPlacementByPackage(String clientCode, String packageId, PageInfo pageInfo, CouponStatus... statusList);
    
    /**
     * 分页列出某个人的所有奖券.
     * 
     * 第一排序是状态，第二排序是获得时间
     * 
     * @param clientCode
     * @param userId
     * @param pageInfo
     * @return 
     */
    PagedResult<CouponPlacement> listUserPlacement(String clientCode, String userId, PageInfo pageInfo);
    
    /**
     * 按照奖券种类分页列出用户的奖券.
     * 
     * 第一排序是状态，第二排序是获得时间
     * 
     * @param clientCode
     * @param userId
     * @param type
     * @param pageInfo
     * @return 
     */
    PagedResult<CouponPlacement> listUserPlacementByType(String clientCode, String userId, CouponType type, PageInfo pageInfo);
    
    /**
     * 按照给定状态分页列出某个人的奖券.
     * 
     * 排序按照获得时间倒序
     * 
     * @param clientCode
     * @param userId
     * @param statusList
     * @param pageInfo
     * @return 
     */
    PagedResult<CouponPlacement> listUserPlacementByStatus(String clientCode, String userId, PageInfo pageInfo, CouponStatus... statusList);
    
}
