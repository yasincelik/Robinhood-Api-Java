package com.ampro.robinhood;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;

import org.junit.Assert;
import org.junit.Test;

import com.ampro.robinhood.endpoint.account.data.AccountHolderInvestmentProfile;
import com.ampro.robinhood.endpoint.orders.data.SecurityOrderElement;
import com.ampro.robinhood.throwables.RobinhoodApiException;

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

    @Override
    public void init() {
        super.init();
        File file = new File("config.txt");
        if (file.canRead())
        {
        	try{
		        List<String> lines = Files.readAllLines(file.toPath());
		        api = new RobinhoodApi(lines.get(0), lines.get(1));
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        }
        else
        {
        	RobinhoodApi.log.log(Level.SEVERE, "Could not read the "
        			+ "config file to get credentials!");
        }
    }

    @Test
    public void getOrders() throws RobinhoodApiException {
        List<SecurityOrderElement> orders = api.getOrders();
        assertNotNull(orders);
        orders.forEach(Assert::assertNotNull);
    }

    @Test
    public void getAccoutInvestmentProfile() throws RobinhoodApiException {
        AccountHolderInvestmentProfile profile = api
                .getAccountInvestmentProfile();
        Assert.assertNotNull(profile);
    }
}
