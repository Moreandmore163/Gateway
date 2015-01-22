/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.lending.api;

import com.creditcloud.model.loan.PlatformRepayment;
import java.util.List;
import javax.ejb.Remote;

/**
 * 获取平台回款计划的服务接口
 */
@Remote
public interface PlatformRepayService {

    PlatformRepayment find(String Id);

    List<PlatformRepayment> listByLoanId(String loanId);

    PlatformRepayment create(PlatformRepayment PlatformRepayment);

}
