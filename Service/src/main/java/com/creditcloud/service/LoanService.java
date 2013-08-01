/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.service;

import com.creditcloud.model.Loan;
import com.creditcloud.model.LoanRequest;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author sobranie
 */
@Remote
public interface LoanService {

    /**
     *
     * @param clientCode
     * @param loanRequest
     * @return 0 for failure, 1 for success, 2 for exceed 3 submit in one day
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    int submitLoanRequest(String clientCode, LoanRequest loanRequest);

    /**
     * cancel a loan request
     *
     * @param clientCode
     * @param requestId
     * @return true if successful
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    boolean cancelLoanRequest(String clientCode, String requestId);

    /**
     * list loan request by user id
     *
     * @param clientCode
     * @param userId
     * @return empty result is no loan found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    List<LoanRequest> listRequestByUserId(String clientCode, String userId);

    /**
     * list loan by user id
     *
     * @param clientCode
     * @param userId
     * @return empty list if nothing found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    List<Loan> listLoanByUserId(String clientCode, String userId);

    /**
     *
     * @param clientCode
     * @param loanId
     * @return true if successful
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    boolean cancelLoan(String clientCode, String loanId);
}
