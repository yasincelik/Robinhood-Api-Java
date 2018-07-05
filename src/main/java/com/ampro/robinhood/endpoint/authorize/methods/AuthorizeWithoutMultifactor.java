package com.ampro.robinhood.endpoint.authorize.methods;

import com.ampro.robinhood.endpoint.authorize.data.Token;
import com.ampro.robinhood.net.request.RequestMethod;

public class AuthorizeWithoutMultifactor extends Authorize {

	public AuthorizeWithoutMultifactor(String username, String password) {
		super();

		setUrlBase("https://api.robinhood.com/api-token-auth/");

		//Add the parameters into the request
		this.addUrlParameter("username", username);
		this.addUrlParameter("password", password);

		this.addHttpHeaderParameter("Content-Type", "application/x-www-form-urlencoded");

		//This needs to be ran as POST
		this.setMethod(RequestMethod.POST);

		//Declare what the response should look like
		this.setReturnType(Token.class);

	}

}
