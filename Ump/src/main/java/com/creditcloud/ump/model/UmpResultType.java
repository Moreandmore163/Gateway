/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.creditcloud.ump.model;

import com.creditcloud.model.BaseObject;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * service调用返回结果. 若调用联动出现错误, 需要根据联动返回的错误运行时创建, 故不能为enum.
 * <br/>
 * <li>3位错误代码为系统端错误</li>
 * <li>6位错误代码为联动端错误</li>
 * 
 * @author kdliu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class UmpResultType extends BaseObject {

    public static final UmpResultType SUCCESS = new UmpResultType(UmpConstant.SUCCESS_CODE, UmpConstant.SUCCESS_MSG);
    public static final UmpResultType NETWORK_ERROR = new UmpResultType("001", "网络错误");
    public static final UmpResultType ACCOUNT_EXIST = new UmpResultType("002", "三方账户已存在");
    
    @NotNull
    private String retCode;

    private String retMsg;
}