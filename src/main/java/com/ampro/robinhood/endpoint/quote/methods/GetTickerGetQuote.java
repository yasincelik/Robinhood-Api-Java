package com.ampro.robinhood.endpoint.quote.methods;

import com.ampro.robinhood.endpoint.quote.data.TickerQuoteElement;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.request.RequestMethod;

/**
 * Created by SirensBell on 6/19/2017.
 */
public class GetTickerGetQuote extends GetQuote {

    public GetTickerGetQuote(String ticker) {
        super();

        this.setUrlBase("https://api.robinhood.com/quotes/" + ticker + "/");

        //Add the header into the request accepting Json
        this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "appliation/json"));

        //This method is ran as GET
        this.setMethod(RequestMethod.GET);

        //Declare what the response should look like
        this.setReturnType(TickerQuoteElement.class);

    }
}
