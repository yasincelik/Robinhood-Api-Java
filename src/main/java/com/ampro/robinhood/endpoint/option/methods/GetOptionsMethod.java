package com.ampro.robinhood.endpoint.option.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.option.data.Options;
import com.ampro.robinhood.net.ApiMethod;
import com.ampro.robinhood.net.request.RequestMethod;

public class GetOptionsMethod extends ApiMethod {

	public GetOptionsMethod(Configuration config) {
		super(config);
		
		this.setMethodType(RequestMethod.GET);
        this.setUrlBase("https://api.robinhood.com/options/aggregate_positions/");
        this.setReturnType(Options.class);
	}

}
