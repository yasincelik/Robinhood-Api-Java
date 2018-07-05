package com.ampro.robinhood.endpoint.quote.methods;


import com.ampro.robinhood.endpoint.quote.data.TickerQuoteElementList;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.request.RequestMethod;
import com.ampro.robinhood.throwables.RequestTooLargeException;

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
public class GetTickerQuoteList extends GetQuote {

    private static int MAX_TICKERS = 5000;

    /**
     * Construct a method to get multiple security quotes by tickers
     * (e.g. MSFT, FIT, etc). <br>
     *     Any tickers that do not exist (at least not on Robinhood) will
     *     be returned as null in the element list.
     *
     * @param tickers The tickers to request quotes of.
     */
    public GetTickerQuoteList(Collection<String> tickers)
    throws RequestTooLargeException {
        super();
        if (tickers.size() > MAX_TICKERS) {
            throw new RequestTooLargeException(
                    "Ticker request must be under " + MAX_TICKERS
            );
        }

        //Reform the collection as a url param
        //replaceAll("[\\[\\]\\s+]", "") replaces "[]" and empty spaces
        // in collection.toString
        StringBuilder list = new StringBuilder("?symbols=")
                .append(tickers.toString().replaceAll("[\\[\\]\\s+]", ""));

        this.setUrlBase("https://api.robinhood.com/quotes/" + list);

        //This method is ran as GET
        this.setMethod(RequestMethod.GET);

        //Declare what the response should look like
        this.setReturnType(TickerQuoteElementList.class);

    }

}
