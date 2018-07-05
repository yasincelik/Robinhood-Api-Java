package com.ampro.robinhood.endpoint.account.methods;


import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.account.data.BasicAccountHolderInfoElement;
import com.ampro.robinhood.net.request.RequestMethod;

public class GetBasicAccountHolderInfo extends Account {

	public GetBasicAccountHolderInfo(Configuration config) {
		super(config);

		this.setUrlBase("https://api.robinhood.com/user/basic_info/");

		//This method is to be ran as GET
		this.setMethod(RequestMethod.GET);

		//Declare what the response should look like
		this.setReturnType(BasicAccountHolderInfoElement.class);
	}

}
