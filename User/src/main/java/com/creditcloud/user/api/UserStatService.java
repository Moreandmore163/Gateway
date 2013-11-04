/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.user.api;

import com.creditcloud.model.ElementCount;
import com.creditcloud.model.enums.Source;
import com.creditcloud.model.enums.user.credit.CertificateType;
import com.creditcloud.model.enums.user.credit.CreditRank;
import com.creditcloud.model.enums.user.credit.ProofType;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author rooseek
 */
@Remote
public interface UserStatService {

    /**
     * 按来源统计用户数
     *
     * @param clientCode
     * @return
     */
    List<ElementCount<Source>> countUserBySource(String clientCode);

    /**
     * 按经办员工统计用户数
     *
     * @param clientCode
     * @param source
     * @return
     */
    List<ElementCount<String>> countUserByEmployee(String clientCode, Source... source);

    /**
     * 按来源统计proof
     *
     * @param clientCode
     * @return
     */
    List<ElementCount<Source>> countProofBySource(String clientCode);

    /**
     * 按经办员工统计proof
     *
     * @param clientCode
     * @param source
     * @return
     */
    List<ElementCount<String>> countProofByEmployee(String clientCode, Source... source);

    /**
     * 按proof类别统计proof
     *
     * @param clientCode
     * @param source
     * @return
     */
    List<ElementCount<ProofType>> countProofByProofType(String clientCode, Source... source);

    /**
     * 按certificate类别统计proof
     *
     * @param clientCode
     * @param source
     * @return
     */
    List<ElementCount<CertificateType>> countProofByCertificateType(String clientCode, Source... source);

    /**
     * 按信用评级统计用户
     *
     * @param clientCode
     * @return
     */
    List<ElementCount<CreditRank>> countUserByCreditRank(String clientCode);
}
