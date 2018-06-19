package com.ampro.robinhood.endpoint.fundamentals.methods;

import com.ampro.robinhood.endpoint.fundamentals.Fundamentals;
import com.ampro.robinhood.endpoint.fundamentals.data.TickerFundamentalElement;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.request.RequestMethod;

public class GetTickerFundamental extends Fundamentals {

	public GetTickerFundamental(String ticker) {

		this.setUrlBase("https://api.robinhood.com/fundamentals/" + ticker +"/");

		//Add the headers into the request
		this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "appliation/json"));

		//This method is ran as GET
		this.setMethod(RequestMethod.GET);

		//Declare what the response should look like
		this.setReturnType(TickerFundamentalElement.class);
	}

}
