/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.crowdfunding.enums;

import com.creditcloud.model.enums.BaseEnum;
import javax.json.Json;

/**
 * 中网小画家 报名状态
 * @author zaishu.ye@fengjr.com
 */
public enum XiaohuajiaSignupStatus implements BaseEnum {
    UPLOAD("待上传"),
    VERIFY("待审核"),
    VERIFY_FAILED("审核失败"),
    VERIFY_SUCCESS("审核通过"),
    ZC_CREATED("众筹中"),
    ZC_FINISHED("众筹完成"),
    ZC_FAILED("众筹失败"),
    ZC_SETTLED("已结算"),
    ZC_ACHIVED("已归档");
    
    private final String key;

    private XiaohuajiaSignupStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    public String toJsonString(){
        return Json.createObjectBuilder().add(this.getClass().getSimpleName(), this.name()).build().toString();
    }
}
