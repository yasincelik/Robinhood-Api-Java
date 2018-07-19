package com.ampro.robinhood.endpoint.authorize.data;

import com.ampro.robinhood.endpoint.ApiElement;

/**
 * Class declaring the return structure so Gson can handle parsing the JSON
 * @author Conrad Weisse
 */
public class Token implements ApiElement {

	private String token = null;

	public String getToken() { return this.token; }

	@Override
	public String toString() { return this.token; }

	@Override
	public boolean requiresAuth() {
		return false;
	}
}
