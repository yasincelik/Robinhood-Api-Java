package com.ampro.robinhood.endpoint.authorize.methods;

import com.ampro.robinhood.ApiMethod;
import com.ampro.robinhood.Configuration;

public abstract class Authorize extends ApiMethod {

	protected Authorize() {
		super("authentication", Configuration.getDefault());
	}

	protected Authorize(Configuration config) {
	    super("authentication", config);
    }

}
