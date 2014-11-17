/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.lending.api;

import com.creditcloud.model.enums.loan.LoanStatus;
import com.creditcloud.model.loan.Loan;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author rooseek
 */
@Remote
public interface LoanService extends LoanQueryService, LoanStatService {

    public Loan find(String id);

    public Loan addNew(Loan loan);

    public void update(Loan loan);

    /**
     * mark loan as cleared
     *
     * @param ids
     * @return
     */
    public boolean markCleared(String... ids);

    /**
     * update loan status
     *
     * @param status
     * @param ids
     * @return
     */
    public boolean markStatus(LoanStatus status, String... ids);

    /**
     * 主要供CreditMarket中更新状态用,只有OPENED/FAILED/FINISHED三种状态可以从CreditMarket更新
     *
     * @param loanId
     * @param status
     * @param bidNumber
     * @param bidAmount
     * @return
     */
    public boolean markStatus(String loanId, LoanStatus status, int bidNumber, int bidAmount);

    /**
     * update loan rewarded
     *
     * @param rewarded
     * @param ids
     * @return
     */
    public boolean markRewarded(boolean rewarded, String... ids);

    /**
     * mark settle time for loan
     *
     * @param loanId
     * @param timeSettled
     * @return
     */
    public boolean markSettleTime(String loanId, Date timeSettled);

}
