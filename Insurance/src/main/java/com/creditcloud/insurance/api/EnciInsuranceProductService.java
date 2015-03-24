/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.insurance.api;

import com.creditcloud.insurance.model.InsuranceProduct;
import com.creditcloud.insurance.model.InsuranceProductInfo;
import com.creditcloud.model.criteria.PageInfo;
import com.creditcloud.model.misc.PagedResult;
import javax.ejb.Remote;

/**
 *
 * @author chai
 */
@Remote
public interface EnciInsuranceProductService {
    
    /**
     * 添加保险产品
     * @param product
     * @return 
     */
    public InsuranceProduct createInsuranceProduct(InsuranceProduct product);
    
    /**
     * 添加保险产品详细信息
     * @param productInfo
     * @return 
     */
    public InsuranceProductInfo createInsuranceProductInfo(InsuranceProductInfo productInfo);
    
    /**
     * 更新产品信息
     * 
     * @param product
     * @return 
     */
    public InsuranceProduct updateInsuranceProduct(InsuranceProduct product);
    
    /**
     * 更新产品详情信息
     * @param productInfo
     * @return 
     */
    public InsuranceProductInfo upInsuranceProductInfo(InsuranceProductInfo productInfo);
    
    /**
     * 查询所有保险产品
     *
     * @param pageInfo
     * @return
     */
    public PagedResult<InsuranceProduct> list(PageInfo pageInfo);
    
    /**
     * 根据ID查询InsuranceProduct
     * @param clientCode
     * @param insuranceProductId
     * @return 
     */
    public InsuranceProduct findInsuranceProductById(String clientCode, String insuranceProductId);
}
