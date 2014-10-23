/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.creditcloud.service.impl;

import com.creditcloud.model.criteria.PageInfo;
import com.creditcloud.model.misc.PagedResult;
import com.creditcloud.service.MarketCustomizeService;
import com.creditcloud.service.model.WechatInfo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rooseek
 */
public abstract class AbstractMarketCustomizeService implements MarketCustomizeService{
    
    @Override
    public int addNews(List<WechatInfo> wis){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public PagedResult<com.creditcloud.service.model.WechatInfo> listWechatInfoByDate(Date from, Date to, PageInfo pageInfo){
        throw new UnsupportedOperationException();
    }
    @Override
    public WechatInfo addWechatInfo(WechatInfo wxi){
        throw new UnsupportedOperationException();
    }
}
