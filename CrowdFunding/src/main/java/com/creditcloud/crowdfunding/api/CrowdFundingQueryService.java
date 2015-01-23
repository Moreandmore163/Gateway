/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.crowdfunding.api;

import com.creditcloud.crowdfunding.enums.ProjectCategory;
import com.creditcloud.crowdfunding.enums.ProjectLoanStatus;
import com.creditcloud.crowdfunding.enums.ProjectStatus;
import com.creditcloud.crowdfunding.model.FavoriteProject;
import com.creditcloud.crowdfunding.model.FundingInvest;
import com.creditcloud.crowdfunding.model.FundingInvestInfo;
import com.creditcloud.crowdfunding.model.FundingProject;
import com.creditcloud.crowdfunding.model.FundingReward;
import com.creditcloud.crowdfunding.model.ProjectLoan;
import com.creditcloud.model.criteria.CriteriaInfo;
import com.creditcloud.model.criteria.PageInfo;
import com.creditcloud.model.enums.loan.InvestStatus;
import com.creditcloud.model.misc.PagedResult;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rooseek
 */
public interface CrowdFundingQueryService {

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
     * @param investId
     * @return
     */
    public FundingInvestInfo getInvestInfoById(String clientCode,
                                               String investId);

    /**
     *
     * @param clientCode
     * @param investId
     * @return
     */
    public FundingInvest getInvestById(String clientCode,
                                       String investId);

    /**
     *
     * @param clientCode
     * @param orderId
     * @return
     */
    public FundingInvest getInvestByOrderId(String clientCode,
                                            String orderId);

    /**
     *
     * @param clientCode
     * @param orderId
     * @return
     */
    public FundingInvestInfo getInvestInfoByOrderId(String clientCode,
                                                    String orderId);

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
     * @param loanId
     * @return
     */
    public ProjectLoan getLoanById(String clientCode, String loanId);

    /**
     *
     * @param clientCode
     * @param loanId
     * @return
     */
    public ProjectLoan getLoanByOrderId(String clientCode, String loanId);

    /**
     *
     * @param clientCode
     * @param info
     * @return
     */
    @Deprecated
    public PagedResult<FundingProject> listProject(String clientCode,
                                                   CriteriaInfo info);

    /**
     *
     * @param clientCode
     * @param statusList
     * @param pageInfo
     * @return
     */
    public PagedResult<FundingProject> listProject(String clientCode,
                                                   List<ProjectStatus> statusList,
                                                   PageInfo pageInfo);

    /**
     *
     * @param clientCode
     * @param statusList
     * @return
     */
    public Map<ProjectStatus, List<FundingProject>> listProject(String clientCode,
                                                                List<ProjectStatus> statusList);

    /**
     *
     * @param clientCode
     * @param statusList
     * @param categoryList
     * @param pageInfo
     * @return
     */
    public PagedResult<FundingProject> listProject(String clientCode,
                                                   List<ProjectStatus> statusList,
                                                   List<ProjectCategory> categoryList,
                                                   PageInfo pageInfo);

    /**
     *
     * @param clientCode
     * @param statusList
     * @return
     */
    public int countProject(String clientCode,
                            List<ProjectStatus> statusList);

    /**
     *
     * @param clientCode
     * @param userId
     * @param statusList
     * @param pageInfo
     * @return
     */
    public PagedResult<FundingProject> listProject(String clientCode,
                                                   String userId,
                                                   List<ProjectStatus> statusList,
                                                   PageInfo pageInfo);

    /**
     *
     * @param clientCode
     * @param userId
     * @param statusList
     * @return
     */
    public int countProject(String clientCode,
                            String userId,
                            List<ProjectStatus> statusList);

    /**
     *
     * @param clientCode
     * @param projectId
     * @return
     */
    public List<FundingReward> listRewardByProject(String clientCode, String projectId);

    /**
     *
     * @param clientCode
     * @param projectId
     * @param statusList
     * @param pageInfo
     * @return
     */
    public PagedResult<FundingInvest> listInvestByProject(String clientCode,
                                                          String projectId,
                                                          List<InvestStatus> statusList,
                                                          PageInfo pageInfo);

    /**
     *
     * @param clientCode
     * @param projectId
     * @param statusList
     * @param pageInfo
     * @return
     */
    public PagedResult<FundingInvestInfo> listInvestInfoByProject(String clientCode,
                                                                  String projectId,
                                                                  List<InvestStatus> statusList,
                                                                  PageInfo pageInfo);

    /**
     *
     * @param clientCode
     * @param projectId
     * @param statusList
     * @return
     */
    public int countInvestByProject(String clientCode,
                                    String projectId,
                                    List<InvestStatus> statusList);

    /**
     * sum invest by project
     *
     * @param clientCode
     * @param projectId
     * @param statusList
     * @return
     */
    public BigDecimal sumInvestByProject(String clientCode, String projectId, List<InvestStatus> statusList);

    /**
     * sum invest by user
     *
     * @param clientCode
     * @param userId
     * @param from
     * @param to
     * @param statusList
     * @return
     */
    public BigDecimal sumInvestByUser(String clientCode, String userId, Date from, Date to, List<InvestStatus> statusList);

    /**
     *
     * @param clientCode
     * @param rewardId
     * @param statusList
     * @param pageInfo
     * @return
     */
    public PagedResult<FundingInvest> listInvestByReward(String clientCode,
                                                         String rewardId,
                                                         List<InvestStatus> statusList,
                                                         PageInfo pageInfo);

    /**
     *
     * @param clientCode
     * @param rewardId
     * @param statusList
     * @param pageInfo
     * @return
     */
    public PagedResult<FundingInvestInfo> listInvestInfoByReward(String clientCode,
                                                                 String rewardId,
                                                                 List<InvestStatus> statusList,
                                                                 PageInfo pageInfo);

    /**
     *
     * @param clientCode
     * @param rewardId
     * @param statusList
     * @return
     */
    public int countInvestByReward(String clientCode,
                                   String rewardId,
                                   List<InvestStatus> statusList);

    /**
     *
     * @param clientCode
     * @param userId
     * @param statusList
     * @param pageInfo
     * @return
     */
    public PagedResult<FundingInvest> listInvestByUser(String clientCode,
                                                       String userId,
                                                       List<InvestStatus> statusList,
                                                       PageInfo pageInfo);

    /**
     *
     * @param clientCode
     * @param userId
     * @param statusList
     * @param pageInfo
     * @return
     */
    public PagedResult<FundingInvestInfo> listInvestInfoByUser(String clientCode,
                                                               String userId,
                                                               List<InvestStatus> statusList,
                                                               PageInfo pageInfo);

    /**
     *
     * @param clientCode
     * @param userId
     * @param statusList
     * @return
     */
    public int countInvestByUser(String clientCode,
                                 String userId,
                                 List<InvestStatus> statusList);

    /**
     *
     * @param clientCode
     * @param projectId
     * @param statusList
     * @return
     */
    public List<ProjectLoan> listLoanByProject(String clientCode, String projectId, List<ProjectLoanStatus> statusList);

    /**
     *
     * @param clientCode
     * @param userId
     * @param pageInfo
     * @return
     */
    public PagedResult<FavoriteProject> listFavoriteByUser(String clientCode, String userId, PageInfo pageInfo);

    /**
     *
     * @param clientCode
     * @param projectId
     * @param pageInfo
     * @return
     */
    public PagedResult<FavoriteProject> listFavoriteByProject(String clientCode, String projectId, PageInfo pageInfo);

    /**
     * 返回某用户喜欢的众筹项目Id列表
     *
     * @param clientCode
     * @param userId
     * @param pageInfo
     * @return list of ProjectId
     */
    public PagedResult<String> listLikeByUser(String clientCode, String userId, PageInfo pageInfo);

    /**
     * 根据下标ordinal返回众筹项目
     *
     * @param clientCode
     * @param ordinal
     * @return empty list if nothing found
     */
    public List<FundingProject> listProjectByOrdinal(String clientCode, int ordinal);

    /**
     * 列出下标区间的众筹项目
     *
     * @param clientCode
     * @param startOrdinal
     * @param endOrdinal
     * @return empty list if nothing found
     */
    public List<FundingProject> listProjectByOrdinal(String clientCode, int startOrdinal, int endOrdinal);

    /**
     * 列出所有下标ordinal非空的众筹项目
     *
     * @param clientCode
     * @return empty list is nothing found
     */
    public List<FundingProject> listAllProjectWithOrdinal(String clientCode);

    /**
     * 根据用户ID和投标起始时间列出用户支持的众筹项目
     *
     * @param clientCode
     * @param userId
     * @param from
     * @param to
     * @param pageInfo
     * @param statusList
     * @return
     */
    public PagedResult<FundingProject> listProjectByUserAndSubmitTime(String clientCode,
                                                                      String userId,
                                                                      Date from,
                                                                      Date to,
                                                                      List<InvestStatus> statusList,
                                                                      PageInfo pageInfo);

    /**
     * 是否是银河国际的众筹项目, 根据是否需要合同来判断,需要则是银河国际的众筹项目
     * @param clientCode
     * @param userId
     * @param from
     * @param to
     * @param statusList
     * @param pageInfo
     * @return 
     */
    PagedResult<String> listProjectByNeedContract(String clientCode,
                                           List<InvestStatus> statusList);
    
    /**
     * 根据用户ID和投标起始时间列出用户投标
     *
     * @param clientCode
     * @param userId
     * @param from
     * @param to
     * @param pageInfo
     * @param statusList
     * @return
     */
    public PagedResult<FundingInvest> listInvestByUserAndSubmitTime(String clientCode,
                                                                    String userId,
                                                                    Date from,
                                                                    Date to,
                                                                    List<InvestStatus> statusList,
                                                                    PageInfo pageInfo);
}
