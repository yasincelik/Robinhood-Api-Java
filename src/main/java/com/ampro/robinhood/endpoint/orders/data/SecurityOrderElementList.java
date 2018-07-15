package com.ampro.robinhood.endpoint.orders.data;

import com.ampro.robinhood.endpoint.ApiElementList;

/**
 * A paginated list of {@link SecurityOrderElement Order elements}.
 * @author Jonathan Augustine
 */
public class SecurityOrderElementList extends ApiElementList<SecurityOrderElement> {
    @Override
    public boolean requiresAuth() { return true; }
}
