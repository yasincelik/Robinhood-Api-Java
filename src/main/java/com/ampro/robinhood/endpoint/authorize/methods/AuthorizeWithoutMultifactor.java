package com.ampro.robinhood.endpoint.authorize.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.authorize.data.Token;
import com.ampro.robinhood.net.request.RequestMethod;
import com.mashape.unirest.http.exceptions.UnirestException;

public class AuthorizeWithoutMultifactor extends Authorize {

	public AuthorizeWithoutMultifactor(String username, String password)
    throws UnirestException {
		super(Configuration.getDefault());

		setUrlBase("https://api.robinhood.com/api-token-auth/");

		//Add the parameters into the request
		this.addFieldParameter("username", username);
		this.addFieldParameter("password", password);

		this.addHeaderParameter("Content-Type", "application/x-www-form-urlencoded");

		//This needs to be ran as POST
		this.setMethodType(RequestMethod.POST);

		//Declare what the response should look like
		this.setReturnType(Token.class);

	}

}
