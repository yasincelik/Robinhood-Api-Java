package com.ampro.robinhood.endpoint.account.methods;


import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.account.data.AccountHolderInvestmentElement;
import com.ampro.robinhood.net.request.RequestMethod;

public class GetAccountHolderInvestmentInfo extends Account {

	public GetAccountHolderInvestmentInfo(Configuration config) {
		super(config);
		this.setUrlBase("https://api.robinhood.com/accounts"
				+ config.getAccountNumber() + "/positions/");

		//This method is to be ran as GET
		this.setMethodType(RequestMethod.GET);

		//Declare what the response should look like
		this.setReturnType(AccountHolderInvestmentElement.class);
	}

}
