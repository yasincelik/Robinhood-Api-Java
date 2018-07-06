package com.ampro.robinhood.net.pagination;

import com.ampro.robinhood.net.ApiMethod;
import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.ApiElementList;
import com.ampro.robinhood.throwables.RobinhoodNotLoggedInException;

/**
 * An API method for pagination
 * @author Jonathan Augustine
 */
public class Paginate extends ApiMethod {

    /**
     * Build a Paginator without Authorization token
     */
    protected Paginate(Class type) {
        super(Configuration.getDefault());
        setReturnType(type);
    }

    /**
     * Build a Paginator with authorization token
     * @param config
     */
    protected Paginate(Class type, Configuration config)
    throws RobinhoodNotLoggedInException {
        super(config);
        addAuthTokenParameter();
        setReturnType(type);
    }

}
