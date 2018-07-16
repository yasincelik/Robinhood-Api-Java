package com.ampro.robinhood.endpoint.account.methods;

import com.ampro.robinhood.net.ApiMethod;
import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.throwables.RobinhoodNotLoggedInException;

public class Account extends ApiMethod {

	protected Account(Configuration config) throws RobinhoodNotLoggedInException {
		super(config);
		//We do require a token for these methods. Thus we require it for
		//all methods using this service
		this.requireToken();
		this.addAuthTokenParameter();
	}

}
