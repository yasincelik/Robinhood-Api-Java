package com.ampro.robinhood.endpoint.quote.methods;


import com.ampro.robinhood.ApiMethod;
import com.ampro.robinhood.request.RequestMethod;

/**
 * Wrapper for HTTP(S) wrapper for making get requests to get security quotes
 * @author Jonathan Augustine
 */
public class GetQuote extends ApiMethod {

    protected GetQuote() {
        super("GetQuote");
        this.addHttpHeaderParameter("Accept", "application/json");
        //This method is ran as GET
        this.setMethod(RequestMethod.GET);
    }
}
