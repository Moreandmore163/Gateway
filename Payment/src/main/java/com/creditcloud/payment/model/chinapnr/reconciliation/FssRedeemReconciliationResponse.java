/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.payment.model.chinapnr.reconciliation;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 生利宝转出对账
 *
 * @author rooseek
 */
@Data
@NoArgsConstructor
public class FssRedeemReconciliationResponse extends ReconciliationResponse {

    private List<FssRedeemReconciliation> FssReconciliationList;

}
