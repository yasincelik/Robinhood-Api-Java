package com.ampro.robinhood.net.pagination;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.net.ApiMethod;

/**
 * An API method for pagination
 * @author Jonathan Augustine
 */
public class Paginate extends ApiMethod {

    /**
     * Build a Paginator
     * @param config A logged in {@link Configuration}
     * @param type The return type
     */
    protected Paginate(Class<?> type, boolean requiresAuth, Configuration config) {
        super(config);
        setReturnType(type);
        if (requiresAuth) {
            this.addAuthTokenParameter();
        }
    }

}
