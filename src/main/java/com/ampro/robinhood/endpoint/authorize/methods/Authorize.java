package com.ampro.robinhood.endpoint.authorize.methods;

import com.ampro.robinhood.net.ApiMethod;
import com.ampro.robinhood.Configuration;

public abstract class Authorize extends ApiMethod {

	protected Authorize(Configuration config) {
	    super("authentication", config);
    }

}
