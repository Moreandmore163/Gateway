/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.config;

import java.net.URL;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  第三方支付需要的配置文件项
 * 
 * @author rooseek
 */
@Data
@NoArgsConstructor
@XmlRootElement(name = "YeepConfig")
@XmlAccessorType(XmlAccessType.FIELD)
public class YeepConfig extends BaseConfig {

    private static final long serialVersionUID = 201401123L;

    public static final String CONFIG_NAME = "YeepConfig";
    
    
    /**
     * 商户编号
     */
    @XmlElement(required = false)
    private String platformNo;
    
    /**
     * 客户私钥文件路径
     */
    @XmlElement(required = false)
    private String privateKeyPath;

    /**
     * 公钥文件路径
     */
    @XmlElement(required = false)
    private String publicKeyPath;
    
    /**
     * 三方支付服务器的URL
     */
    @XmlElement(required = false)
    private URL url;  
    
    /**
     * 三方支付服务的远程路径
     */
    @XmlElement(required = false)
    private String path;

    /**
     * 三方支付回调的Url，一般是网站运行的地址
     */
    @XmlElement(required = false)
    private String retUrl;
    
    /**
     * Manager三方支付回调url
     */
    @XmlElement(required = false)
    private String adminRetUrl;    
   
}
