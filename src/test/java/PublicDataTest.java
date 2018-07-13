import com.ampro.robinhood.RobinhoodApi;
import com.ampro.robinhood.endpoint.fundamentals.data.TickerFundamentalElement;
import com.ampro.robinhood.endpoint.instrument.data.InstrumentElement;
import com.ampro.robinhood.endpoint.instrument.data.InstrumentElementList;
import com.ampro.robinhood.endpoint.instrument.methods.GetAllInstruments;
import com.ampro.robinhood.endpoint.instrument.methods.GetInstrumentByUrl;
import com.ampro.robinhood.endpoint.quote.data.TickerQuoteElement;
import com.ampro.robinhood.net.ApiMethod;
import com.ampro.robinhood.net.pagination.PaginatedIterator;
import com.ampro.robinhood.net.request.RequestManager;
import com.ampro.robinhood.throwables.RequestTooLargeException;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.ampro.robinhood.throwables.TickerNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PublicDataTest {
    static RobinhoodApi api;
    static RequestManager requestManager;
    static List<String> tenTickers;
    static String MSFT;
    static String MSFT_URL;
    static String FAKE;
    static String KEYWORD;

    @Before
    public void init() {
        api = new RobinhoodApi();
        requestManager = RequestManager.getInstance();
        tenTickers = new ArrayList<>(Arrays.asList(
                "MSFT", "VT", "VTI", "BAC", "DIS",
                "FB", "TSLA", "AAPL", "INTC", "BABA"
        ));
        MSFT = "MSFT";
        MSFT_URL = "https://api.robinhood" +
                ".com/instruments/50810c35-d215-4866-9758-0ada4ac79ffa/";
        FAKE = "KOKOBOKO";
        KEYWORD = "INC";
    }

    //Fundimentals
    @Test
    public void getTickerFundimental() throws RobinhoodApiException {
        TickerFundamentalElement msft = api.getFundamental(MSFT);
        assertEquals(false, msft == null);
    }

    @Test
    public void getTickerFundimentalList() throws RobinhoodApiException {
        List<TickerFundamentalElement> list = api.getFundimentalList(tenTickers);
        list.forEach( element -> assertEquals(false, element == null));
    }

    @Test(expected = RequestTooLargeException.class)
    public void tickerListTooLarge() throws RobinhoodApiException {
        tenTickers.add("GE");
        api.getFundimentalList(tenTickers);
    }

    //Instruments
    @Test
    public void getInstrumentByTicker() throws RobinhoodApiException {
        InstrumentElement instrument = api.getInstrumentByTicker(MSFT);
        assertEquals(false, instrument == null);
    }

    @Test(expected = TickerNotFoundException.class)
    public void getFakeTickerInstrument() throws RobinhoodApiException {
        api.getInstrumentByTicker(FAKE);
    }

    @Test
    public void getInstrumentByUrl() throws RobinhoodApiException {
        ApiMethod method = new GetInstrumentByUrl(MSFT_URL);
        InstrumentElement instrument = requestManager.makeApiRequest(method);
        assertEquals(false, instrument == null);
    }

    @Test
    public void getAllInstruments()
    throws RobinhoodApiException {
        allInstruments = api.getAllInstruments();
        allInstruments.forEach(element -> assertEquals(false, element == null));
    }

    @Test
    public void searchInstrumentByKeyword() throws RobinhoodApiException {
        api.getInstrumentsByKeyword(KEYWORD);
    }

    //Quotes
    @Test
    public void getQuote() throws RobinhoodApiException {
        TickerQuoteElement quote = api.getQuoteByTicker(MSFT);
        assertEquals(false, quote == null);
    }

    @Test(expected = TickerNotFoundException.class)
    public void getFakeQuote() throws RobinhoodApiException {
        api.getQuoteByTicker(FAKE);
    }

    private List<InstrumentElement> allInstruments;

    private List<InstrumentElement> getAllInst() throws RobinhoodApiException {
        if (allInstruments == null) {
            allInstruments = api.getAllInstruments();
        }
        return allInstruments;
    }

    @Test
    public void getQuoteList() throws RobinhoodApiException {
        List<String> tickers = new ArrayList<>();
        List<InstrumentElement> list = getAllInst().subList(0, 1100);

        list.forEach( element -> tickers.add(element.getSymbol()) );

        api.getQuoteListByTickers(tickers);

    }

    @Test(expected = RequestTooLargeException.class)
    public void quotelistTooLarge() throws RobinhoodApiException {
        List<String> tickers = new ArrayList<>();
        List<InstrumentElement> list = getAllInst().subList(0, 1631);
        list.forEach( element -> tickers.add(element.getSymbol()));
        api.getQuoteListByTickers(tickers);
    }

    //Pagination
    @Test
    public void paginatedIterator() throws RobinhoodApiException {
        InstrumentElementList list = requestManager
                .makeApiRequest(GetAllInstruments.getDefault());
        PaginatedIterator<InstrumentElement> iterator
                = new PaginatedIterator<>(list);
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    @Test
    public void paginatedIterable() throws RobinhoodApiException {
        InstrumentElementList list = requestManager
                .makeApiRequest(GetAllInstruments.getDefault());
        Iterable<InstrumentElement> iterable = api.buildIterable(list);
        iterable.forEach(instrumentElement -> {});
    }

}
