package com.ampro.robinhood.endpoint.account.methods;


import com.ampro.robinhood.ConfigurationManager;
import com.ampro.robinhood.endpoint.account.Account;
import com.ampro.robinhood.endpoint.account.data.AccountHolderInvestmentElement;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.request.RequestMethod;

public class GetAccountHolderInvestmentInfo extends Account {

	public GetAccountHolderInvestmentInfo() {

		this.setUrlBase("https://api.robinhood.com/accounts" + ConfigurationManager.getInstance().getAccountNumber() + "/positions/");

		//Add the headers into the request
		this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "application/json"));

		//This method is to be ran as GET
		this.setMethod(RequestMethod.GET);

		//Declare what the response should look like
		this.setReturnType(AccountHolderInvestmentElement.class);
	}

}
