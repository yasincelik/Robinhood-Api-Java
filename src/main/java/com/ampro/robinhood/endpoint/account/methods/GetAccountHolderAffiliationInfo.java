package com.ampro.robinhood.endpoint.account.methods;


import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.account.data.AccountHolderAffiliationElement;
import com.ampro.robinhood.net.request.RequestMethod;

public class GetAccountHolderAffiliationInfo extends Account {

	public GetAccountHolderAffiliationInfo(Configuration config) {
		super(config);

		this.setUrlBase("https://api.robinhood.com/user/additional_info/");

		//This method is ran as GET
		this.setMethod(RequestMethod.GET);

		//Declare what the response should look like
		this.setReturnType(AccountHolderAffiliationElement.class);
	}


}
