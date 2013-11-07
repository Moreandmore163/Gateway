/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.user.api;

import com.creditcloud.model.user.User;
import com.creditcloud.model.criteria.CriteriaInfo;
import com.creditcloud.model.criteria.PageInfo;
import com.creditcloud.model.enums.Source;
import com.creditcloud.model.misc.PagedResult;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;

/**
 *
 * @author sobranie
 */
@Remote
public interface UserService extends UserSecurityService {

    /**
     * list all users for client
     *
     * @param clientCode
     * @return empty list if no user found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    List<User> listAllUsers(String clientCode);

    /**
     * count all users for client
     *
     * @param clientCode
     * @return
     */
    int countByClient(String clientCode);

    /**
     * 列出员工开户的用户列表
     *
     * @param clientCode
     * @param employeeId
     * @param source
     * @return
     */
    PagedResult<User> listByEmployee(String clientCode, String employeeId, PageInfo info, Source... source);

    /**
     * list all users with criteria for client
     *
     * @param clientCode
     * @param criteriaInfo
     * @return empty result is no user found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    PagedResult<User> listUsers(String clientCode, CriteriaInfo criteriaInfo);

    /**
     * 增加一个用户，属于后台或平板开户，系统生成随机密码发送到用户手机
     *
     * @param clientCode
     * @param user
     * @return user created
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    User addUser(String clientCode, User user);

    /**
     * 增加一个用户，前台开户流程，传入的用户密码是由用户直接设置
     *
     * @param clientCode
     * @param user
     * @param password
     * @return
     */
    User addUser(String clientCode,
                 User user,
                 String password,
                 Map<String, String> loginInfo,
                 Source source);

    /**
     * update user information for client
     *
     * @param clientCode
     * @param user
     * @return user after update
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    User updateUser(String clientCode, User user);

    //find methods
    /**
     * find user by login name
     *
     * @param clientCode
     * @param loginName
     * @return null if not found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    User findByLoginName(String clientCode, String loginName);

    /**
     * find user by user Id
     *
     * @param clientCode
     * @param userId
     * @return null if not found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    User findByUserId(String clientCode, String userId);

    /**
     * find user by mobile number
     *
     * @param clientCode
     * @param mobile
     * @return null if not found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    User findByMobile(String clientCode, String mobile);

    /**
     * find user by idNumber
     *
     * @param clientCode
     * @param idNumber
     * @return null if not found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    User findByIdNumber(String clientCode, String idNumber);

    /**
     * find user by email
     *
     * @param clientCode
     * @param email
     * @return null if not found
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    User findByEmail(String clientCode, String email);

    /**
     * delete user by user Id
     *
     * @param clientCode
     * @param Id
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    void deleteByUserId(String clientCode, String userId);

    //check methods used on registration
    /**
     * Check if the mobile is available.
     *
     * @param clientCode
     * @param mobile
     * @return true if this mobile is available, false if already occupied.
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    boolean checkMobile(String clientCode, String mobile);

    /**
     * Check if the idNumber is available
     *
     * @param clientCode
     * @param idNumber
     * @return true if this idNumber is available, false if already occupied
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    boolean checkIdNumber(String clientCode, String idNumber);

    /**
     * Check if the loginName is available.
     *
     * @param clientCode
     * @param loginName
     * @return true if this loginName is available, false if already taken.
     * @throw ClientCodeNotMatchException if incoming client code do not match
     * the local client
     */
    boolean checkLoginName(String clientCode, String loginName);
}
