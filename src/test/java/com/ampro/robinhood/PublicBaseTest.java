package com.ampro.robinhood;

import com.ampro.robinhood.endpoint.fundamentals.data.TickerFundamentalElement;
import com.ampro.robinhood.endpoint.instrument.data.InstrumentElement;
import com.ampro.robinhood.endpoint.instrument.data.InstrumentElementList;
import com.ampro.robinhood.endpoint.instrument.methods.GetAllInstruments;
import com.ampro.robinhood.endpoint.quote.data.TickerQuoteElement;
import com.ampro.robinhood.net.pagination.PaginatedIterator;
import com.ampro.robinhood.throwables.RequestTooLargeException;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.ampro.robinhood.throwables.TickerNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class PublicBaseTest extends BaseTest {

    //Fundimentals
    @Test
    public void getTickerFundimental() {
        TickerFundamentalElement msft = api.getFundamental(MSFT);
        assertNotNull(msft);
    }

    @Test
    public void getTickerFundimentalList() throws RobinhoodApiException {
        List<TickerFundamentalElement> list = api.getFundamentalList(tenTickers);
        list.forEach(Assert::assertNotNull);
    }

    @Test(expected = RequestTooLargeException.class)
    public void tickerListTooLarge() throws RobinhoodApiException {
        tenTickers.add("GE");
        api.getFundamentalList(tenTickers);
    }

    //Quotes
    @Test
    public void getQuote() throws RobinhoodApiException {
        TickerQuoteElement quote = api.getQuoteByTicker(MSFT);
        assertNotNull(quote);
    }

    @Test(expected = TickerNotFoundException.class)
    public void getFakeQuote() throws RobinhoodApiException {
        api.getQuoteByTicker(FAKE);
    }

    @Test
    public void getQuoteList() throws RobinhoodApiException {
        List<String> tickers = new ArrayList<>();
        List<InstrumentElement> list = preLoadAllInstruments().subList(0, 1100);

        list.forEach( element -> tickers.add(element.getSymbol()) );

        api.getQuoteListByTickers(tickers);

    }

    @Test(expected = RequestTooLargeException.class)
    public void quotelistTooLarge() throws RobinhoodApiException {
        List<String> tickers = new ArrayList<>();
        List<InstrumentElement> list = preLoadAllInstruments().subList(0, 1631);
        list.forEach( element -> tickers.add(element.getSymbol()));
        api.getQuoteListByTickers(tickers);
    }

    //Pagination
    @Test
    public void paginatedIterator() {
        InstrumentElementList list = requestManager
                .makeApiRequest(GetAllInstruments.getDefault());
        PaginatedIterator<InstrumentElement> iterator
                = new PaginatedIterator<>(list);
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    @Test
    public void paginatedIterable() {
        InstrumentElementList list = requestManager
                .makeApiRequest(GetAllInstruments.getDefault());
        Iterable<InstrumentElement> iterable = api.buildIterable(list);
        iterable.forEach(instrumentElement -> {});
    }

}
