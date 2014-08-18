/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.creditcloud.ump.model.ump.trade;

import com.creditcloud.ump.model.ump.base.NotifyRequest;
import com.creditcloud.ump.model.ump.enums.CmdIdType;
import lombok.Data;

/**
 *
 * @author kdliu
 */
@Data
public class TradeTransferNotifyRequest extends NotifyRequest {
    
    private String order_id;
    
    private String mer_date;
    
    private String trade_no;
    
    private String mer_check_date;
    
    public TradeTransferNotifyRequest(String mer_id, 
                                      String version,
                                      String order_id, 
                                      String mer_date, 
                                      String trade_no, 
                                      String mer_check_date,
                                      String ret_code,
                                      String ret_msg) {
        super(CmdIdType.TRANSFER_NOTIFY, mer_id, ret_code, ret_msg);
        this.order_id = order_id;
        this.mer_date = mer_date;
        this.trade_no = trade_no;
        this.mer_check_date = mer_check_date;
    }    
}
