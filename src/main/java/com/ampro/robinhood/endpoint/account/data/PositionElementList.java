package com.ampro.robinhood.endpoint.account.data;

import com.ampro.robinhood.endpoint.ApiElementList;

/**
 * A paginated list of a user's positions
 * @author Jonathan Augustine
 */
public class PositionElementList extends ApiElementList<PositionElement> {
    @Override
    public boolean requiresAuth() { return true; }

}
