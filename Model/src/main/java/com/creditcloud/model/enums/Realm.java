/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.model.enums;

/**
 * 定义实体相关的域
 *
 * @author rooseek
 */
public enum Realm implements BaseEnum {

    /**
     * 基本类型
     */
    USER("用戶"),
    EMPLOYEE("员工"),
    ROLE("角色"),
    CLIENT("客戶"),
    /**
     * 认证
     */
    PROOF("证明"),
    CERTIFICATE("认证"),
    VEHICLE("车辆"),
    REALESTATE("房产"),
    /**
     * 借款贷款
     */
    INVEST("投标"),
    LOAN("贷款"),
    INVESTREPAYMENT("投资还款"),
    LOANREPAYMENT("贷款还款"),
    LOANREQUEST("贷款申请"),
    TASK("任务"),
    /**
     * 业务类型
     */
    WITHDRAW("取现"),
    /**
     * 其他
     */
    IMAGE("图片"),
    FILE("文件");
    
    private final String key;

    private Realm(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
