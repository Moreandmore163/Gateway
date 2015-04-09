package com.creditcloud.fund.api;

import com.creditcloud.fund.model.FundEvent;
import java.util.Date;
import javax.ejb.Remote;

/**
 * Created with IntelliJ IDEA.
 * User: meichao
 * Date: 2015/3/26
 * Time: 15:23
 * Desc:
 * To change this template use File | Settings | File Templates.
 */
@Remote
public interface FundEventService {

    /**
     * 活动当前状态
     * 
     * @return 
     * 若活动有效，返回"ok"
     * 否则，返回提示信息
     */
    String eventActiveStatus(String eventId);
    
    String eventActiveStatus(String eventId, Date date);
    
    /**
     * 根据id获取FundEvent
     * @param eventId
     * @return 
     */
    FundEvent getFundEvent(String eventId);
}
