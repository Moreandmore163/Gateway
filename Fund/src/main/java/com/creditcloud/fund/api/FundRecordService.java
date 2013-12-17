/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.fund.api;

import com.creditcloud.fund.model.ClientFundRecord;
import com.creditcloud.fund.model.record.FundRecord;
import com.creditcloud.fund.model.record.FundWithdraw;
import com.creditcloud.fund.model.enums.FundRecordOperation;
import com.creditcloud.fund.model.enums.FundRecordStatus;
import com.creditcloud.fund.model.enums.FundRecordType;
import com.creditcloud.fund.model.record.FundDeposit;
import com.creditcloud.fund.model.record.FundInvest;
import com.creditcloud.model.criteria.PageInfo;
import com.creditcloud.model.misc.PagedResult;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author rooseek
 */
@Remote
public interface FundRecordService {

    /**
     *
     * @param clientCode
     * @param id
     * @return
     */
    FundRecord getById(String clientCode, String id);

    /**
     * 
     * @param clientCode
     * @param userId
     * @param type
     * @param orderId
     * @return 
     */
    FundRecord getByUserAndTypeAndOrderId(String clientCode, String userId, FundRecordType type, String orderId);

    /**
     * create new fund record
     *
     * @param clientCode
     * @param record
     * @return
     */
    FundRecord addNew(String clientCode, FundRecord record);

    /**
     * update exist fund record
     *
     * @param clientCode
     * @param record
     */
    void update(String clientCode, FundRecord record);

    /**
     * 更新FundRecord状态
     *
     * @param clientCode
     * @param status
     */
    void updateStatus(String clientCode, String recordId, FundRecordStatus status);

    /**
     *
     * @param clientCode
     * @param userId
     * @param startDate
     * @param endDate
     * @param pageInfo
     * @param type
     * @return
     */
    PagedResult<FundRecord> listByUser(String clientCode,
                                       String userId,
                                       Date startDate,
                                       Date endDate,
                                       PageInfo pageInfo,
                                       FundRecordType... type);

    /**
     *
     * @param clientCode
     * @param userId
     * @param pageInfo
     * @param type
     * @param operation
     * @return
     */
    PagedResult<FundRecord> listByUserAndTypeAndOperation(String clientCode,
                                                          String userId,
                                                          PageInfo pageInfo,
                                                          List<FundRecordType> type,
                                                          List<FundRecordOperation> operation);

    /**
     * 返回所有待处理的提现申请记录.
     *
     * @param clientCode
     * @return
     */
    List<FundWithdraw> listWithdrawRequest(String clientCode);

    /**
     * 根据orderId查找FundInvest
     *
     * @param clientCode
     * @param userId
     * @param orderId
     * @return
     */
    FundInvest getFundInvestByOrderId(String clientCode, String userId, String orderId);

    /**
     * 根据orderId查找FundDeposit
     *
     * @param clientCode
     * @param userId
     * @param orderId
     * @return
     */
    FundDeposit getFundDepositByOrderId(String clientCode, String userId, String orderId);

    /**
     * 根据orderId查找FundWithdraw
     *
     * @param clientCode
     * @param userId
     * @param orderId
     * @return
     */
    FundWithdraw getFundWithdrawByOrderId(String clientCode, String userId, String orderId);

    /**
     * 根据operation和status查找FundInvest
     *
     * @param clientCode
     * @param userId
     * @param investId
     * @param operation
     * @param status
     * @return
     */
    FundInvest getFundInvestByOperationAndStatus(String clientCode,
                                                 String userId,
                                                 String investId,
                                                 FundRecordOperation operation,
                                                 FundRecordStatus status);

    /**
     * 根据operation和status查找FundWithdraw
     *
     * @param clientCode
     * @param userId
     * @param withdrawId
     * @param operation
     * @param status
     * @return
     */
    FundWithdraw getWithdrawByOperationAndStatus(String clientCode,
                                                 String userId,
                                                 String withdrawId,
                                                 FundRecordOperation operation,
                                                 FundRecordStatus status);

    /**
     * 查看投标进行到那一步,投标成功、取消、已结算
     *
     * @param clientCode
     * @param userId
     * @param investId
     * @return null for no record
     */
    Pair<FundRecordStatus, FundRecord> checkInvest(String clientCode,
                                                   String userId,
                                                   String investId);

    /**
     * 查看投标的第几期还款是否已经还清
     *
     * @param clientCode
     * @param userId
     * @param investId
     * @param period
     * @return
     */
    boolean checkInvestRepay(String clientCode, String userId, String investId, int period);

    /**
     * 结标成功生成对应的record
     *
     * @param clientCode
     * @param investUserId
     * @param investId
     * @param investAmount
     * @param loanUserId
     * @param loanId
     * @param fee
     */
    void settleInvestRecord(String clientCode,
                            String investUserId,
                            String investId,
                            BigDecimal investAmount,
                            String loanUserId,
                            String loanId,
                            Map<FundRecordType, BigDecimal> feeDetails,
                            String orderId);

    /**
     * 还款成功生成对应的record
     *
     * @param clientCode
     * @param investUserId
     * @param investId
     * @param repayAmount
     * @param loanUserId
     * @param loanId
     * @param feeDetails
     * @param orderId
     * @param period
     */
    void repayInvestRecord(String clientCode,
                           String investUserId,
                           String investId,
                           BigDecimal repayAmount,
                           String loanUserId,
                           String loanId,
                           Map<FundRecordType, BigDecimal> feeDetails,
                           String orderId,
                           int period);

    /**
     * 商户子账户之间转账
     *
     * @param clientCode
     * @param inAccount  入账子账户
     * @param outAccount 出账子账户
     * @param amount
     */
    void clientTransfer(String clientCode,
                        String inAccount,
                        BigDecimal amount,
                        String outAccount,
                        String orderId);

    /**
     * 商户和用户之间转账
     *
     * @param clientCode
     * @param account    商户子账户
     * @param amount
     * @param userId     用户
     * @param transferIn true for transfer from client to user
     */
    void userTransfer(String clientCode,
                      String account,
                      BigDecimal amount,
                      String userId,
                      boolean transferIn,
                      String orderId);
}
