package com.ampro.robinhood.endpoint.account.methods;

import com.ampro.robinhood.endpoint.account.Account;
import com.ampro.robinhood.endpoint.account.data.AccountArrayWrapper;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.request.RequestMethod;

/**
 * An {@link com.ampro.robinhood.ApiMethod} used to get a list of a user's
 * accounts.
 * !!NOTE~~ As of 3/7/2018, this will only ever return a single account, so we
 * will see what the Robinhood team does there...maybe
 * @author Conrad Weisse
 */
public class GetAccounts extends Account {

	/**
	 * Get a list of a user's accounts. <br>
	 * <b>(ONLY CONTAINS 1 ACCOUNT ELEMENT AS OF 3/7/2018)</b>
	 */
	public GetAccounts()  {
		this.setUrlBase("https://api.robinhood.com/accounts/");

		//Add the headers into the request
		this.addHttpHeaderParameter(
				new HttpHeaderParameter("Accept", "application/json")
		);

		//This method is ran as GET
		this.setMethod(RequestMethod.GET);

		//Declare what the response should look like
		this.setReturnType(AccountArrayWrapper.class);
	}

}
