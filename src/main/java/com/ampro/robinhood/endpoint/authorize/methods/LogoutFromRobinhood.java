package com.ampro.robinhood.endpoint.authorize.methods;


import com.ampro.robinhood.endpoint.authorize.Authentication;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.request.RequestMethod;

public class LogoutFromRobinhood extends Authentication {

	public LogoutFromRobinhood() {

		this.setUrlBase("https://api.robinhood.com/api-token-logout/");

		//Add the header parameters
		this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "application/json"));

		//This needs to be ran as POST
		this.setMethod(RequestMethod.POST);

		//We are not expecting a response back.
		this.setReturnType(Void.TYPE);
	}

}
