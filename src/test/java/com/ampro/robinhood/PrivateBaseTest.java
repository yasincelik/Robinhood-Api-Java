package com.ampro.robinhood;

import com.ampro.robinhood.endpoint.account.data.AccountHolderInvestmentProfile;
import com.ampro.robinhood.endpoint.orders.data.SecurityOrderElement;
import com.ampro.robinhood.throwables.NotLoggedInException;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
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

    protected RobinhoodApi loggedInApi;

    @Override
    public void init() {
        super.init();
        File file = new File("config.txt");
        if (file.canRead()) {
        	try{
		        List<String> lines = Files.readAllLines(file.toPath());
		        loggedInApi = new RobinhoodApi(lines.get(0), lines.get(1));
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        }
        else {
        	RobinhoodApi.log.log(Level.SEVERE, "Could not read the "
        			+ "config file to get credentials!");
        }
    }

    @Test
    public void failedLogin() {
        try {
            new RobinhoodApi("email", "password");
        } catch (RobinhoodApiException e) {
            assertEquals(e.getMessage(), "Failed to log user in: no token");
        }
    }

    @Test(expected = NotLoggedInException.class)
    public void notLoggedInAccount() {
        api.getAccountData();
    }

    @Test
    public void getOrders() {
        List<SecurityOrderElement> orders = loggedInApi.getOrders();
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
