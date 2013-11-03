/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.service;

import com.creditcloud.model.criteria.PageInfo;
import com.creditcloud.model.enums.loan.LoanRequestStatus;
import com.creditcloud.model.loan.LoanRequest;
import com.creditcloud.model.loan.SubmitRequestResult;
import com.creditcloud.model.misc.PagedResult;
import javax.ejb.Remote;

/**
 *
 * @author rooseek
 */
@Remote
public interface LoanRequestService {

    /**
     *
     * @param clientCode
     * @param loanRequest
     * @return SubmitRequestResult
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    SubmitRequestResult submitLoanRequest(String clientCode, LoanRequest loanRequest);

    /**
     * get LoanRequest by id
     *
     * @param clientCode
     * @param requestId
     * @return LoanRequest
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    LoanRequest getRequestById(String clientCode, String requestId);


    /**
     * list loan request by user id
     *
     * @param clientCode
     * @param userId
     * @param pageInfo
     * @param status
     * @return empty result is no loan found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    PagedResult<LoanRequest> listRequestByUserAndStatus(String clientCode,
                                                        String userId,
                                                        PageInfo pageInfo,
                                                        LoanRequestStatus... status);

    /**
     * list loan request by employee id
     *
     * @param clientCode
     * @param employeeId
     * @param pageInfo
     * @param status
     * @return empty result is no loan found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    PagedResult<LoanRequest> listRequestByEmployeeAndStatus(String clientCode,
                                                            String employeeId,
                                                            PageInfo pageInfo,
                                                            LoanRequestStatus... status);

    /**
     * update a loan request from CreditMarket
     *
     * @param clientCode
     * @param request
     * @return
     */
    boolean updateLoanRequest(String clientCode,
                              LoanRequest request);
}
