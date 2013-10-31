/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.creditcloud.email.api;

import com.creditcloud.email.types.ConfirmResult;
import com.creditcloud.email.types.Email;
import com.creditcloud.model.client.Client;
import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 *
 * @author rooseek
 */
@Remote
public interface EmailService {

    /**
     * send email to user on the behalf of this client
     *
     * There is no guarantee that the user will receive this mail successfully
     * now.
     *
     * @param client
     * @param mail
     */
    Future<Boolean> send(Client client, Email mail);

    /**
     * send email to user informing successful registration after activation
     *
     * @param client
     * @param emailAddress
     * @return
     */
    Future<Boolean> sendRegistration(Client client, String emailAddress);

    Future<Boolean> sendRegistration(Client client, String emailAddress, String personal);

    /**
     * send activation email to user during registration
     *
     * @param client
     * @param emailAddress
     * @return
     */
    Future<Boolean> sendActivation(Client client, String emailAddress);

    Future<Boolean> sendActivation(Client client, String emailAddress, String personal);

    /**
     * send authentication email to user for binding email
     *
     * @param client
     * @param emailAddress
     * @param personal
     * @return
     */
    Future<Boolean> sendAuthentication(Client client, String emailAddress, String personal);

    Future<Boolean> sendAuthentication(Client client, String emailAddress);

    /**
     * Confirm the emailAddress is valid, and activate the email
     *
     * The caller will guarantee this email has not been confirmed yet.
     *
     * @param client
     * @param emailAddress
     * @param confirmCode
     * @return
     */
    ConfirmResult confirmEmail(Client client, String emailAddress, String confirmCode);

    /**
     * check whether email is already activated on behalf of this client
     *
     * @param client
     * @param emailAddress
     * @return
     */
    boolean isActivated(Client client, String emailAddress);
}
