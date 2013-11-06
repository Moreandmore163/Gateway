/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.payment.model.chinapnr;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author sobranie
 */
public class BgBindCardResponse extends BaseResponse {

    @FormParam("UserCustId")
    @NotNull
    @Size(max = 16)
    private String UsrCustId;

    @FormParam("OpenAcctId")
    @NotNull
    @Size(max = 40)
    private String OpenAcctId;

    @FormParam("OpenBankId")
    @NotNull
    @Size(max = 8)
    private String OpenBankId;
    
    public BgBindCardResponse() {
    }

    @Override
    public String chkString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.baseChkString())
                .append(StringUtils.trimToEmpty(getUsrCustId()))
                .append(StringUtils.trimToEmpty(getOpenAcctId()))
                .append(StringUtils.trimToEmpty(getOpenBankId()))
                .append(StringUtils.trimToEmpty(getMerPriv()));
        return sb.toString();
    }

    public String getUsrCustId() {
        return UsrCustId;
    }

    public void setUsrCustId(String UsrCustId) {
        this.UsrCustId = UsrCustId;
    }

    public String getOpenAcctId() {
        return OpenAcctId;
    }

    public void setOpenAcctId(String OpenAcctId) {
        this.OpenAcctId = OpenAcctId;
    }

    public String getOpenBankId() {
        return OpenBankId;
    }

    public void setOpenBankId(String OpenBankId) {
        this.OpenBankId = OpenBankId;
    }

}
