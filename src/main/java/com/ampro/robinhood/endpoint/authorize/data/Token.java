package com.ampro.robinhood.endpoint.authorize.data;

/**
 * Class declaring the return structure so Gson can handle parsing the JSON
 * @author Conrad Weisse
 */
public class Token {

	private String token = null;

	public String getToken() { return this.token; }

	@Override
	public String toString() { return this.token; }

}
