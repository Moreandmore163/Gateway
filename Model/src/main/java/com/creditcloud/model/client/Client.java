/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.model.client;

import com.creditcloud.model.BaseObject;
import com.creditcloud.model.constraints.ClientCode;
import com.creditcloud.model.constraints.ClientURL;
import com.creditcloud.model.constraints.EmailAddress;
import com.creditcloud.model.constraints.MobileNumber;
import java.util.Locale;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表示客户机构
 *
 * @author sobranie
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client extends BaseObject {

    private static final long serialVersionUID = 20130918L;

    /**
     * full name of the client
     */
    @FormParam("name")
    @NotNull
    protected String name;

    /**
     * 客户简称
     */
    @FormParam("shortName")
    @NotNull
    private String shortName;
    
    /**
     * 显示在Market上的title
     */
    @FormParam("title")
    @NotNull
    private String title;
    
    /**
     * 系统使用的手机，用于发送重要消息
     */
    @FormParam("mobile")
    @MobileNumber
    private String mobile;
    
    /**
     * 技术支持邮件，在异常等状况下应用
     */
    @FormParam("supportEmail")
    @EmailAddress
    private String supportEmail;

    /**
     * 4 characters codes 唯一标识
     */
    @FormParam("code")
    @ClientCode
    protected String code;

    /**
     * url
     */
    @FormParam("url")
    @ClientURL
    protected String url;

    /**
     * locale setting for this client
     */
    @NotNull
    protected Locale locale;
    
}
