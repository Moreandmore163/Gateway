/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.model.enums.client;

import com.creditcloud.model.enums.BaseEnum;
import com.creditcloud.model.enums.Realm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 员工权限集合
 *
 * @author sobranie
 *
 */
public enum Privilege implements BaseEnum {

    /**
     * 用户相关权限
     */
    USER_LIST("列出用户", Realm.USER, "用户相关权限"),
    USER_DETAIL("查看用户详情,包括用户的各种认证信息", Realm.USER, "用户相关权限"),
    USER_ALTER("添加更改用户信息,包括上传用户认证信息", Realm.USER, "用户相关权限"),
    USER_DELETE("禁用用户", Realm.USER, "用户相关权限"),
    USER_DOWNLOAD("下载用户信息", Realm.USER, "用户相关权限"),
    /**
     * 员工相关权限
     */
    EMPLOYEE_LIST("列出员工", Realm.EMPLOYEE, "员工相关权限"),
    EMPLOYEE_DETAIL("查看员工详情", Realm.EMPLOYEE, "员工相关权限"),
    EMPLOYEE_ADD("添加员工记录", Realm.EMPLOYEE, "员工相关权限"),
    EMPLOYEE_ALTER("更改员工信息", Realm.EMPLOYEE, "员工相关权限"),
    EMPLOYEE_DELETE("删除员工", Realm.EMPLOYEE, "员工相关权限"),
    EMPLOYEE_GRANT("调整员工权限", Realm.EMPLOYEE, "员工相关权限"),
    EMPLOYEE_RESETPASSWORD("重置员工密码", Realm.EMPLOYEE, "员工相关权限"),
    /**
     * 组织结构相关
     */
    ROLE_VIEW("查看角色权限配置", Realm.ROLE, "组织结构相关"),
    ROLE_ASSIGN("分配角色权限", Realm.ROLE, "组织结构相关"),
    /**
     * 借款申请相关权限
     */
    LOANREQUEST_LIST("列出借款申请", Realm.LOANREQUEST, "借款申请相关权限"),
    LOANREQUEST_DETAIL("查看借款申请详情，包括申请的各种认证信息", Realm.LOANREQUEST, "借款申请相关权限"),
    LOANREQUEST_ALTER("更改借款申请信息，包括上传申请认证信息", Realm.LOANREQUEST, "借款申请相关权限"),
    LOANREQUEST_QUICK("快速录入借款申请，包括用户及其银行卡", Realm.LOANREQUEST, "借款申请相关权限"),
    LOANREQUEST_EDIT("借款申请调整", Realm.LOANREQUEST, "借款申请相关权限"),
    /**
     * 调控借款申请的流程<p>
     * 例如申请提交后先让初审和(风控)人员审核借款和客户信息<p>
     * 根据初审意见再給外勤人员分配实地勘察任务,外勤人员完成任务后任务评审通过.<p>
     * 再推进流程让风控人员介入评审制定授信额度等<p>
     * 出现逾期和违约时再分配催款任务让外勤人员介入
     */
    LOANREQUEST_REVIEW("借款申请评审", Realm.LOANREQUEST, "借款申请相关权限"),
    LOANREQUEST_APPROVE("批准借款申请", Realm.LOANREQUEST, "借款申请相关权限"),
    LOANREQUEST_REJECT("拒绝借款申请，添加审批意见后打回用户", Realm.LOANREQUEST, "借款申请相关权限"),
    /**
     * 借款相关权限
     */
    LOAN_DETIAL("借款详情", Realm.LOAN, "借款相关权限"),
    LOAN_LIST("列出借款", Realm.LOAN, "借款相关权限"),
    LOAN_SPLIT("借款申请批准后拆标", Realm.LOAN, "借款相关权限"),
    LOAN_SCHEDULE("拆标后发标", Realm.LOAN, "借款相关权限"),
    LOAN_SETTLE("借款满标流标后审核", Realm.LOAN, "借款相关权限"),
    POST_LOAN_MANAGE("贷后管理", Realm.LOAN, "借款相关权限"),
    LOAN_REPAY("还款", Realm.LOAN, "借款相关权限"),
    LOAN_DISBURSE("垫付", Realm.LOAN, "借款相关权限"),
    LOAN_DOWNLOAD("借款下载", Realm.LOAN, "借款相关权限"),
    LOAN_CANCEL("取消借款标", Realm.LOAN, "借款相关权限"),  //在后台取消前台正在OPEN或者SCHEDULED状态的loan
    /**
     * 任务相关权限
     */
    TASK_ASSIGN("创建和分配任务", Realm.TASK, "任务相关权限"),
    TASK_UNDERTAKE("承接和执行任务", Realm.TASK, "任务相关权限"),
    TASK_REVIEW("评审任务", Realm.TASK, "任务相关权限"),
    /**
     * 资金相关权限
     */
    FUND_VIEW("查看平台资金", Realm.FUND, "资金相关权限"),
    FUND_RECONCILIATION("商户对账", Realm.FUND, "资金相关权限"),
    CLIENT_CASH_AUDIT("商户提现审批", Realm.FUND, "资金相关权限"),
    USER_CASH_AUDIT("用户提现审批", Realm.FUND, "资金相关权限"),
    USER_CASH_REQUEST("用户提现申请", Realm.FUND, "资金相关权限"),  //代用户提交取现申请，与用户快速提现有区别，需要进一步审核
    FUND_DEPOSIT("商户充值", Realm.FUND, "资金相关权限"),
    FUND_WITHDRAW("商户提现", Realm.FUND, "资金相关权限"),
    FUND_WITHDRAW_DOWNLOAD("提现记录下载", Realm.FUND, "资金相关权限"),
    CLIENT_DIRECT_WITHDRAW("商户快速提现", Realm.FUND, "资金相关权限"),
    USER_DIRECT_WITHDRAW("用户快速提现", Realm.FUND, "资金相关权限"),
    CLIENT_TRANSFER("商户调账", Realm.FUND, "资金相关权限"),
    USER_TRANSFER("商户向用户转账", Realm.FUND, "资金相关权限"),
    USER_TRANSFER_AUDIT("商户向用户转账审批", Realm.FUND, "资金相关权限"),
    /**
     * 合同相关权限
     */
    CONTRACT_VIEW("查看借款合同", Realm.CONTRACT, "合同相关权限"),
    CONTRACT_REGENERATE("重新生成借款合同", Realm.CONTRACT, "合同相关权限"),
    CONTRACTS_VIEW("合同管理", Realm.CONTRACT, "合同相关权限"),
    /**
     * 机构相关权限
     */
    BRANCH_LIST("列出机构", Realm.BRANCH, "机构相关权限"),
    BRANCH_DETAIL("机构详情", Realm.BRANCH, "机构相关权限"),
    BRANCH_ALTER("更改添加机构", Realm.BRANCH, "机构相关权限"),
    BRANCH_DELETE("删除机构", Realm.BRANCH, "机构相关权限"),
    /**
     * 认购相关权限
     */
    APPOINT_USER_IMPORT("导入认购用户", Realm.APPOINTMENT, "认购相关权限"),
    APPOINT_LIST("列出认购产品", Realm.APPOINTMENT, "认购相关权限"),
    APPOINT_DETAIL("认购产品详情", Realm.APPOINTMENT, "认购相关权限"),
    APPOINT_ALTER("添加更改认购产品", Realm.APPOINTMENT, "认购相关权限"),
    APPOINT_DELETE("删除认购产品", Realm.APPOINTMENT, "认购相关权限");

    private final String key;

    private final Realm realm;

    private final String description;

    /**
     * realm所属的所有priviledges
     */
    private static final Map<Realm, List<Privilege>> realm2Privilege = new HashMap<>();

    static {
        for (Privilege privilege : Privilege.values()) {
            List<Privilege> privilegeList = realm2Privilege.get(privilege.getRealm());
            if (privilegeList == null) {
                privilegeList = new ArrayList<>();
                privilegeList.add(privilege);
                realm2Privilege.put(privilege.getRealm(), privilegeList);
            } else {
                realm2Privilege.get(privilege.getRealm()).add(privilege);
            }
        }
    }

    Privilege(String key, Realm realm, String description) {
        this.key = key;
        this.realm = realm;
        this.description = description;
    }

    @Override
    public String getKey() {
        return key;
    }

    public Realm getRealm() {
        return realm;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 获得realm所有对应的priviledge
     *
     * @param realm
     * @return
     */
    public static List<Privilege> listByIncludedRealm(Realm... realms) {
        if (realms == null || realms.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<Privilege> result = new ArrayList<>();
        for (Realm realm : realms) {
            List<Privilege> temp = realm2Privilege.get(realm);
            if (temp != null && !temp.isEmpty()) {
                result.addAll(temp);
            }
        }
        return result;
    }

    /**
     * 列出所有不属于realm的priviledge,主要给不同的客户权限管理显示不同的可用权限列表
     *
     * @param realms
     * @return
     */
    public static List<Privilege> listByExcludedRealm(Realm... realms) {
        List<Privilege> result = new ArrayList<>();
        Set excludedRealms = new HashSet(Arrays.asList(realms));
        for (Realm realm : realm2Privilege.keySet()) {
            if (!excludedRealms.contains(realm)) {
                List<Privilege> temp = realm2Privilege.get(realm);
                if (temp != null && !temp.isEmpty()) {
                    result.addAll(temp);
                }
            }
        }
        return result;
    }
}
