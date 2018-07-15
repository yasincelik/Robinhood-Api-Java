package com.ampro.robinhood;

import com.ampro.robinhood.endpoint.orders.data.SecurityOrderElement;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.ampro.robinhood.throwables.RobinhoodNotLoggedInException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

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
public class PrivateDataTest extends DataTest {

    @Override
    public void init() throws Exception {
        super.init();
        File file = new File("config.txt");
        if (!file.canRead())
            throw new RobinhoodNotLoggedInException("Requires a login config.");
        List<String> lines = Files.readAllLines(file.toPath());
        api = new RobinhoodApi(lines.get(0), lines.get(1));
    }

    @Test
    public void getOrders() throws RobinhoodApiException {
        List<SecurityOrderElement> orders = api.getOrders();
        assertNotNull(orders);
        orders.forEach(Assert::assertNotNull);
    }
}
