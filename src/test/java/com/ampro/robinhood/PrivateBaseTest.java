package com.ampro.robinhood;

import com.ampro.robinhood.endpoint.account.data.AccountHolderInvestmentProfile;
import com.ampro.robinhood.endpoint.authorize.AuthorizationData;
import com.ampro.robinhood.endpoint.orders.data.SecurityOrder;
import com.ampro.robinhood.endpoint.authorize.LoginStatus;
import com.ampro.robinhood.throwables.NotLoggedInException;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Tests getting private data.
 *
 * !! If you use this test, you need a config.txt file with your
 * login information. This file is ignored. DO NOT UPLOAD YOUR LOGIN
 * INFORMATION !! you hvae been warned
 *
 * @author Jonathan Augustine
 */
public class PrivateBaseTest extends BaseTest {

    protected static RobinhoodApi loggedInApi;
    private boolean mfaRun = false;

    @Override
    public void init() throws IOException, RobinhoodApiException {
        super.init();
        if (loggedInApi == null) {
            File file = new File("config.txt");
            if (file.canRead()) {
                this.multifactorLogin();
            } else {
                RobinhoodApi.log.log(Level.SEVERE, "Could not read the "
                        + "config file to get credentials!");
            }
        }
    }

    /** This test requires the tester's account to use multifactor login */
    @Test
    public void multifactorLogin() throws IOException {
        if (mfaRun) return;
        RobinhoodApi testApi = new RobinhoodApi();
        File file = new File("config.txt");
        List<String> lines = Files.readAllLines(file.toPath());
        AuthorizationData data = testApi.loadAuthData(lines.get(0), lines.get(1));
        if (!data.mfaRequired()) {
            loggedInApi = testApi;
            mfaRun = true;
            return;
        }
        String code = JOptionPane.showInputDialog("Code (put 0 if no mfa)");
        LoginStatus status = testApi.loginMfa(lines.get(0), lines.get(1), code);
        assertEquals("SUCCESS", status.toString());
        assertNotNull(data);
        assertNotNull(data.getToken());
        loggedInApi = testApi;
        mfaRun = true;
    }

    @Test
    public void failedLogin() {
        try {
            new RobinhoodApi("email", "password");
        } catch (RobinhoodApiException e) {
            assertEquals("Failed to log user in: no token", e.getMessage());
        }
    }

    @Test(expected = NotLoggedInException.class)
    public void notLoggedInAccount() {
        api.getAccountData();
    }

    @Test
    public void getOrders() {
        List<SecurityOrder> orders = loggedInApi.getOrders();
        assertNotNull(orders);
        orders.forEach(Assert::assertNotNull);
    }

    @Test
    public void getAccountInvestmentProfile() {
        AccountHolderInvestmentProfile profile = loggedInApi
                .getAccountInvestmentProfile();
        Assert.assertNotNull(profile);
    }

}
