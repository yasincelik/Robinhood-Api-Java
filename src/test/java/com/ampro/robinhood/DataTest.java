package com.ampro.robinhood;

import com.ampro.robinhood.RobinhoodApi;
import com.ampro.robinhood.net.request.RequestManager;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataTest {
    static RobinhoodApi api;
    static RequestManager requestManager;
    static List<String> tenTickers;
    static String MSFT;
    static String MSFT_URL;
    static String FAKE;
    static String KEYWORD;

    @Before
    public void init() throws Exception {
        api = new RobinhoodApi();
        requestManager = RequestManager.getInstance();
        tenTickers = new ArrayList<>(Arrays.asList(
                "MSFT", "VT", "VTI", "BAC", "DIS",
                "FB", "TSLA", "AAPL", "INTC", "BABA"
        ));
        MSFT = "MSFT";
        MSFT_URL = "https://api.robinhood" +
                ".com/instruments/50810c35-d215-4866-9758-0ada4ac79ffa/";
        FAKE = "KOKOBOKO";
        KEYWORD = "INC";
    }

}
