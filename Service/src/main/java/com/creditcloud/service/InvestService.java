/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.service;

import com.creditcloud.model.User;
import com.creditcloud.model.loan.Invest;
import com.creditcloud.model.loan.InvestRepayment;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author rooseek
 */
@Remote
public interface InvestService {
    /**
     * list Invest by user Id
     *
     * @param clientCode
     * @param userId
     * @return empty list if nothing found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    List<Invest> listInvestbyUserId(String clientCode, String userId);

    /**
     * list Invest by loan Id
     *
     * @param clientCode
     * @param loanId
     * @return empty list if nothing found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    List<Invest> listInvestByLoanId(String clientCode, String loanId);

    /**
     * list InvestRepayment by invest id
     *
     * @param clientCode
     * @param investId
     * @return empty list if nothing found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    List<InvestRepayment> listRepayByInvestId(String clientCode, String investId);

    /**
     * list all users who invest in a certain loan
     *
     * @param clientCode
     * @param loanId
     * @return empty list if nothing found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    List<User> listUserByLoanId(String clientCode, String loanId);
}
