package com.ampro.robinhood.endpoint.authorize.methods;

import com.ampro.robinhood.endpoint.authorize.Authentication;
import com.ampro.robinhood.endpoint.authorize.data.Token;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.parameters.UrlParameter;
import com.ampro.robinhood.request.RequestMethod;

public class AuthorizeWithoutMultifactor extends Authentication {

	public AuthorizeWithoutMultifactor(String username, String password) {

		setUrlBase("https://api.robinhood.com/api-token-auth/");

		//Add the parameters into the request
		this.addUrlParameter(new UrlParameter("username", username));
		this.addUrlParameter(new UrlParameter("password", password));

		this.addHttpHeaderParameter("Content-Type", "application/x-www-form-urlencoded");

		//This needs to be ran as POST
		this.setMethod(RequestMethod.POST);

		//Declare what the response should look like
		this.setReturnType(Token.class);

	}

}
