package com.creditcloud.fund.api;

import com.creditcloud.fund.model.CouponRecord;
import com.creditcloud.fund.model.enums.CouponStatus;
import com.creditcloud.fund.model.enums.CouponType;
import com.creditcloud.model.ElementCount;
import com.creditcloud.model.criteria.PageInfo;
import com.creditcloud.model.misc.PagedResult;
import com.creditcloud.model.misc.RealmEntity;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 * Created with IntelliJ IDEA. User: meichao Date: 2015/3/23 Time: 16:01 To
 * change this template use File | Settings | File Templates.
 */
@Remote
public interface FengCouponRecordService {

    /**
     * 用户参加活动获取的红包数量
     *
     * @return
     */
    List<ElementCount<String>> countGroupByUserEvent();

    int countByUserEvent(String userId, String eventNo);

    CouponRecord saveCoupon(CouponRecord coupon);

    /**
     * 根据用户ID，券类型查找券列表
     *
     * @param userId
     * @param couponType
     * @return
     */
    List<CouponRecord> listByType(String userId, CouponType couponType);

    /**
     * 券（红包）列表
     *
     * @param userId 用户ID
     * @param info 分页
     * @param statusList CouponStatus
     * @return
     */
    PagedResult<CouponRecord> listByTypeStatus(String userId, List<CouponType> type, List<CouponStatus> status, PageInfo info);

    /**
     * 根据用户ID，券类型，当前时间，状态列表查找券列表 按时间、金额正排序
     *
     * @param userId
     * @param couponType
     * @param nowTime
     * @return
     */
    List<com.creditcloud.fund.model.CouponRecord> listByTypeDateStatus(String userId,
                                                                              List<CouponType> types,
                                                                              Date nowTime,
                                                                              List<CouponStatus> status);

    /**
     * 查询用户参加活动获取的红包
     *
     * @param userId
     * @param eventId
     * @return
     */
    List<CouponRecord> listByEventId(String userId, String eventId);

    /**
     * 绑定标的ID及更新状态
     *
     * @param id
     * @param status
     * @param oldStatus
     * @param entity
     * @return
     */
    boolean working(CouponRecord coupon, RealmEntity entity);

    /**
     * 置红包为已兑换
     *
     * @param coupon
     * @return
     */
    boolean exchanged(CouponRecord coupon);

}
