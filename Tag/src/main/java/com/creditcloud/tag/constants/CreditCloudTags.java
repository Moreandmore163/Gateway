/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.tag.constants;

import com.creditcloud.model.enums.Realm;
import com.creditcloud.tag.model.Tag;

/**
 * 预定义的tags
 *
 * @author rooseek
 */
public interface CreditCloudTags {

    /**
     * VIP客户
     */
    Tag VIP_USER = new Tag(Realm.STRING, "VIP", "贵宾客户");

    /**
     * 平台运营方相关的内部客户
     */
    Tag INTERNAL_USER = new Tag(Realm.STRING, "内部用户", "内部用户客户");

    /**
     * 个人用途借款
     */
    Tag LOAN_PERSONAL = new Tag(Realm.STRING, "个人借款", "个人借款");

    /**
     * 个人代表企业借款
     */
    Tag LOAN_COMPANY = new Tag(Realm.STRING, "企业借款", "个人代表企业借款");

    /**
     * 个人代销理财产品
     */
    Tag LOAN_WEALTH = new Tag(Realm.STRING, "理财产品", "个人代销理财产品");

}
