package com.ampro.robinhood.endpoint.fundamentals.data;

import com.ampro.robinhood.endpoint.ApiElementList;

public class TickerFundimentalElementList
        extends ApiElementList<TickerFundamentalElement> {
    @Override
    public boolean requiresAuth() { return false; }
}
