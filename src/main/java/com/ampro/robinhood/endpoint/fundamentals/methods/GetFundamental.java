package com.ampro.robinhood.endpoint.fundamentals.methods;

import com.ampro.robinhood.net.ApiMethod;
import com.ampro.robinhood.Configuration;

/**
 * @author Conrad Weiser
 */
public class GetFundamental extends ApiMethod {

    protected GetFundamental() {
        super("fundamentals", Configuration.getDefault());
    }

	protected GetFundamental(Configuration configuration) {
		super("fundamentals", configuration);
	}

}
