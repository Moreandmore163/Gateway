/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.service;

import com.creditcloud.model.criteria.PageInfo;
import com.creditcloud.model.enums.loan.InvestStatus;
import com.creditcloud.model.enums.loan.LoanStatus;
import com.creditcloud.model.loan.Invest;
import com.creditcloud.model.loan.Loan;
import com.creditcloud.model.loan.LoanInvestStatistics;
import com.creditcloud.model.loan.LoanRepayment;
import com.creditcloud.model.loan.SettleLoanResult;
import com.creditcloud.model.misc.PagedResult;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author rooseek
 */
@Remote
public interface InvestService extends InvestRepayService {

    /**
     * list Invest by user Id
     *
     * @param clientCode
     * @param userId
     * @param info
     * @param status
     * @return empty list if nothing found or status is null or empty
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    PagedResult<Invest> listInvestbyUser(String clientCode, String userId, PageInfo info, InvestStatus... status);

    /**
     * list Invest by loan Id
     *
     * @param clientCode
     * @param loanId
     * @param info
     * @return empty list if nothing found or status is null or empty
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    PagedResult<Invest> listInvestByLoan(String clientCode, String loanId, PageInfo info, InvestStatus... status);

    /**
     * notify a status of loan to all its invests
     *
     * @param clientCode
     * @param loanId
     * @param status
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    void notifyLoanStatus(String clientCode, String loanId, LoanStatus status);

    /**
     * settle a loan , generate related invest repayment
     *
     * @param clientCode
     * @param loanId
     * @return 根据贷款所有投资金额生成的还款计划，用于更新贷款的LoanRepayment中的Repayment
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    SettleLoanResult settleLoan(String clientCode, Loan loan);

    /**
     * cancel failed loan , release related invest
     *
     * @param clientCode
     * @param loan
     */
    boolean cancelFailedLoan(String clientCode, Loan loan);

    /**
     * repayment of a loan, set repayment status and generate fund record
     *
     * @param clientCode
     * @param loanRepay
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    boolean repayLoan(String clientCode, LoanRepayment loanRepay);

    /**
     * 商户垫付支付
     *
     * @param clientCode
     * @param loanRepay
     * @return
     */
    boolean disburseLoan(String clientCode, LoanRepayment loanRepay);

    /**
     * 统计用户对贷款的投资信息
     *
     * @param clientCode
     * @param userId
     * @return
     */
    LoanInvestStatistics getLoanInvestStatistics(String clientCode, String userId);

    /**
     * 获取opened状态的贷款的投标数
     *
     * @param clientCode
     * @return
     */
    Map<String, Integer> getOpenLoanBidNumber(String clientCode);

    /**
     * 获取opened状态的贷款的可投标余额
     *
     * @param clientCode
     * @return
     */
    Map<String, Integer> getOpenLoanBalance(String clientCode);
}
