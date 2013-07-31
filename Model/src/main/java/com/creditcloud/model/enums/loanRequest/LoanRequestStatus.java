/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.model.enums.loanRequest;

import com.creditcloud.model.enums.BaseEnum;

/**
 *
 * @author rooseek
 */
public enum LoanRequestStatus implements BaseEnum {

    UNASSIGNED("未处理"),
    ASSIGNED("已处理"),
    CANCELED("已取消"),//只有在UNASSIGNED和ASSIGNED状态的可以取消
    APPROVED("已批准"),
    PUBLISHED("已发放"),
    ARCHIVED("已存档"),
    DELETED("已刪除");

    private final String key;

    private LoanRequestStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    /**
     * check whether a loan request can be canceled
     *
     * @param status
     * @return true if UNASSIGNED or ASSIGNED, false else
     */
    public static boolean tryCancel(LoanRequestStatus status) {
        switch (status) {
            case UNASSIGNED:
            case ASSIGNED:
                return true;
        }

        return false;
    }
}
