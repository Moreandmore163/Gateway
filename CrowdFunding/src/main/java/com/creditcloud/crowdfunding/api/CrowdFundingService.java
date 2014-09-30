/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.crowdfunding.api;

import com.creditcloud.crowdfunding.model.FundingInvest;
import com.creditcloud.crowdfunding.model.FundingProject;
import com.creditcloud.crowdfunding.model.FundingReward;
import com.creditcloud.model.enums.loan.InvestStatus;
import javax.ejb.Remote;

/**
 *
 * @author rooseek
 */
@Remote
public interface CrowdFundingService extends CrowdFundingQueryService {

    /**
     *
     * @param clientCode
     * @param project
     * @return
     */
    public FundingProject addProject(String clientCode, FundingProject project);

    /**
     *
     * @param clientCode
     * @param project
     * @return
     */
    public FundingProject updateProject(String clientCode, FundingProject project);
    
    /**
     *
     * @param clientCode
     * @param projectId
     * @return
     */
    public FundingProject getProjectById(String clientCode, String projectId);

    /**
     *
     * @param clientCode
     * @param reward
     * @return
     */
    public FundingReward addReward(String clientCode, FundingReward reward);

    /**
     *
     * @param clientCode
     * @param reward
     * @return
     */
    public FundingReward updateReward(String clientCode, FundingReward reward);

    /**
     *
     * @param clientCode
     * @param rewardId
     * @return
     */
    @Deprecated
    public boolean deleteReward(String clientCode, String rewardId);

    /**
     *
     * @param clientCode
     * @param rewardId
     * @return
     */
    public FundingReward getRewardById(String clientCode, String rewardId);

    /**
     *
     * @param clientCode
     * @param invest
     * @return
     */
    public FundingInvest addInvest(String clientCode, FundingInvest invest);

    /**
     *
     * @param clientCode
     * @param currentStatus current status
     * @param newStatus        status after update
     * @param investIds
     * @return
     */
    public boolean markInvestStatus(String clientCode,
                                    InvestStatus currentStatus,
                                    InvestStatus newStatus,
                                    String... investIds);
}
