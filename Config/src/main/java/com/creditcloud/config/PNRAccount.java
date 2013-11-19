/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.config;

import com.creditcloud.model.BaseObject;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 汇付天下商户子账户配置
 *
 * @author rooseek
 */
@XmlRootElement(name = "PNRAccount")
@XmlAccessorType(XmlAccessType.FIELD)
public class PNRAccount extends BaseObject {

    /*
     * 账户类型
     */
    @XmlElement(required = true)
    private String accountType;

    /**
     * 账户id
     */
    @XmlElement(required = true)
    private String accountId;

    public PNRAccount() {
    }

    public PNRAccount(String accountType, String accountId) {
        this.accountType = accountType;
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountId() {
        return accountId;
    }
}
