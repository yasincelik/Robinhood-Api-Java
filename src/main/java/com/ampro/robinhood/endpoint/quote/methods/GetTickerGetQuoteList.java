package com.ampro.robinhood.endpoint.quote.methods;


import com.ampro.robinhood.endpoint.quote.TickerQuoteElementList;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.request.RequestMethod;

import java.util.Collection;

/**
 * (from <a href="https://github.com/sanko/Robinhood/blob/master/Quote.md#gather-quote-data-for-multiple-ticker-symbols-in-a-single-api-call">
     Unofficial Robinhood API
      </a>)<br>
 * "Gather quote data for a list of symbols at once...Returned data is
 * semi-paginated (in that there are no next or previous keys)." <br>
 *     Returns a {@link TickerQuoteElementList}.
 *
 * @author Jonathan Augustine
 */
public class GetTickerGetQuoteList extends GetQuote {

    /**
     * Construct a method to get multiple security quotes by tickers
     * (e.g. MSFT, FIT, etc). <br>
     *     Any tickers that do not exist (at least not on Robinhood) will
     *     be returned as null in the element list.
     *
     * @param tickers The tickers to request quotes of.
     */
    public GetTickerGetQuoteList(Collection<String> tickers) {
        super();

        //Reform the collection as a url param
        //replaceAll("[\\[\\]\\s+]", "") replaces "[]" and empty spaces
        // in collection.toString
        StringBuilder list = new StringBuilder("?symbols=")
                .append(tickers.toString().replaceAll("[\\[\\]\\s+]", ""));

        this.setUrlBase("https://api.robinhood.com/quotes/" + list);

        //Add the header into the request accepting Json
        this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "appliation/json"));

        //This method is ran as GET
        this.setMethod(RequestMethod.GET);

        //Declare what the response should look like
        this.setReturnType(TickerQuoteElementList.class);

    }

}
