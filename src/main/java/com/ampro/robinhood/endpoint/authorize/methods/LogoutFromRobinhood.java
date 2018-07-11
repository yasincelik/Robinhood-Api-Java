package com.ampro.robinhood.endpoint.authorize.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.net.request.RequestMethod;

public class LogoutFromRobinhood extends Authorize {

	public LogoutFromRobinhood(Configuration configuration) {
		super(configuration);

		this.setUrlBase("https://api.robinhood.com/api-token-logout/");

		//This needs to be ran as POST
		this.setMethodType(RequestMethod.POST);

		//We are not expecting a response back.
		this.setReturnType(Void.TYPE);
	}

}
