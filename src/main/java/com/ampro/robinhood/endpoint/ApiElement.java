package com.ampro.robinhood.endpoint;

/**
 * A basis class for elements received from the Robinhood API
 * @author Jonathan Augustine
 */
public abstract class ApiElement {

    /**If the element requires an authorized API (i.e. Is user-specific data)*/
    protected final boolean reqAuth;

    protected ApiElement(boolean requiresAuth) {
        this.reqAuth = requiresAuth;
    }
}
