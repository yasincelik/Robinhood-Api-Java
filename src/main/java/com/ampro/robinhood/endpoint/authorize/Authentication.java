package com.ampro.robinhood.endpoint.authorize;

import com.ampro.robinhood.ApiMethod;

public abstract class Authentication extends ApiMethod {

	protected Authentication() {
		super("authentication");
		this.addHttpHeaderParameter("Accept", "application/json");

	}

}
