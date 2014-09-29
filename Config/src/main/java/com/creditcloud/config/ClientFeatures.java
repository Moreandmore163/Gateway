/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.config;

import com.creditcloud.model.BaseObject;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 不通用的平台特殊功能
 *
 * @author rooseek
 */
@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientFeatures extends BaseObject {

    private static final long serialVersionUID = 20140729L;

    /**
     * 保理业务
     */
    @XmlElement
    @Getter
    private boolean enableFactoring = false;

    /**
     * PDF电子签章与签名 (for fmax)
     */
    @XmlElement
    @Getter
    private boolean enablePDFSignature = false;
    
    /**
     * 话务系统
     * 自动登录管理后台 (for ifeng)
     */
    @XmlElement
    @Getter
    private boolean enableServiceHotline = false;
}
