package com.ampro.robinhood.endpoint.account.methods;


import com.ampro.robinhood.endpoint.account.Account;
import com.ampro.robinhood.endpoint.account.data.BasicAccountHolderInfoElement;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.request.RequestMethod;

public class GetBasicAccountHolderInfo extends Account {

	public GetBasicAccountHolderInfo() {

		this.setUrlBase("https://api.robinhood.com/user/basic_info/");

		//Add the headers into the request
		this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "application/json"));

		//This method is to be ran as GET
		this.setMethod(RequestMethod.GET);

		//Declare what the response should look like
		this.setReturnType(BasicAccountHolderInfoElement.class);
	}

}
