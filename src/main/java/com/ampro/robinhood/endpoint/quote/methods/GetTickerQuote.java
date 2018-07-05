package com.ampro.robinhood.endpoint.quote.methods;

import com.ampro.robinhood.endpoint.quote.data.TickerQuoteElement;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.request.RequestMethod;

/**
 * Created by SirensBell on 6/19/2017.
 */
public class GetTickerQuote extends GetQuote {

    public GetTickerQuote(String ticker) {
        super();
        this.setUrlBase("https://api.robinhood.com/quotes/" + ticker + "/");
        //Declare what the response should look like
        this.setReturnType(TickerQuoteElement.class);
    }
}
