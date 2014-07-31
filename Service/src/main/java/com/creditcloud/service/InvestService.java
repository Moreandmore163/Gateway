/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.service;

import com.creditcloud.model.criteria.PageInfo;
import com.creditcloud.model.enums.loan.DisburseType;
import com.creditcloud.model.enums.loan.InvestStatus;
import com.creditcloud.model.enums.loan.LoanStatus;
import com.creditcloud.model.enums.loan.RepayType;
import com.creditcloud.model.loan.Invest;
import com.creditcloud.model.loan.Loan;
import com.creditcloud.model.loan.LoanInvestStatistics;
import com.creditcloud.model.loan.LoanRepayment;
import com.creditcloud.model.loan.SettleLoanResult;
import com.creditcloud.model.misc.PagedResult;
import com.creditcloud.model.user.ReferralUser;
import java.util.Date;
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
     * @param status
     * @return empty list if nothing found or status is null or empty
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    PagedResult<Invest> listInvestByLoan(String clientCode, String loanId, PageInfo info, InvestStatus... status);

    /**
     * count Invest by loan id
     *
     * @param clientCode
     * @param loanId
     * @param status
     * @return
     */
    int countInvestByLoan(String clientCode, String loanId, InvestStatus... status);

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
     * @param loan
     * @return 根据贷款所有投资金额生成的还款计划，用于更新贷款的LoanRepayment中的Repayment
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    SettleLoanResult settleLoan(String clientCode, Loan loan);

    /**
     * 结标后的一些可能需要的操作<p>
     * 将所有平台相关交由market处理,避免manager开出太多分支<p>
     *
     * @param clientCode
     * @param loan
     */
    void postSettle(String clientCode, Loan loan);

    /**
     * cancel failed loan , release related invest
     *
     * @param clientCode
     * @param loan
     * @return
     */
    boolean cancelFailedLoan(String clientCode, Loan loan);

    /**
     * cancel scheduled loan, remove scheduled loan from market cache
     *
     * @param clientCode
     * @param loanId
     * @return
     */
    boolean cancelScheduledLoan(String clientCode, String loanId);

    /**
     * repayment of a loan, set repayment status and generate fund record
     *
     * @param clientCode
     * @param repayDetails
     * @param type         TODO目前只有提前还款用到此参数
     * @return
     */
    boolean repayLoan(String clientCode, Map<String, Object> repayDetails, RepayType type);

    /**
     * 商户垫付支付
     *
     * @param clientCode
     * @param loanRepay
     * @param type
     * @return
     */
    boolean disburseLoan(String clientCode, LoanRepayment loanRepay, DisburseType type);

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

    /**
     * 根据Id获取开标状态的Loan
     *
     * @param clientCode
     * @param loanId
     * @return
     */
    Loan getOpenLoanById(String clientCode, String loanId);

    /**
     * 取消用户的投标
     *
     * @param clientCode
     * @param investId
     * @return
     */
    boolean cancelInvest(String clientCode, String investId);

    /**
     * 根据Id获得invest
     *
     * @param clientCode
     * @param investId
     * @return
     */
    Invest getInvestById(String clientCode, String investId);

    /**
     * list referral info by user
     *
     * @param clientCode
     * @param userId
     * @param from
     * @param to
     * @param pageInfo
     * @return
     */
    PagedResult<ReferralUser> listByReferral(String clientCode, String userId, Date from, Date to, PageInfo pageInfo);
}
