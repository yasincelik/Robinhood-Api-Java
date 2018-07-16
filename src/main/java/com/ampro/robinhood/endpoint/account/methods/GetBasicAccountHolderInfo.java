package com.ampro.robinhood.endpoint.account.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.account.data.BasicAccountHolderInfoElement;
import com.ampro.robinhood.net.request.RequestMethod;
import com.ampro.robinhood.throwables.RobinhoodNotLoggedInException;

public class GetBasicAccountHolderInfo extends Account {

	public GetBasicAccountHolderInfo(Configuration config)
	throws RobinhoodNotLoggedInException {
		super(config);

		this.setUrlBase(RH_URL + "/user/basic_info/");

		//This method is to be ran as GET
		this.setMethodType(RequestMethod.GET);

		//Declare what the response should look like
		this.setReturnType(BasicAccountHolderInfoElement.class);
	}

}
