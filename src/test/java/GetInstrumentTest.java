import com.ampro.robinhood.RobinhoodApi;
import com.ampro.robinhood.endpoint.instrument.data.InstrumentElement;
import com.ampro.robinhood.endpoint.instrument.data.InstrumentElementList;
import com.ampro.robinhood.endpoint.instrument.methods.GetAllInstruments;
import com.ampro.robinhood.endpoint.quote.data.TickerQuoteElement;
import com.ampro.robinhood.net.request.RequestManager;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.ampro.robinhood.throwables.TickerNotFoundException;

public class GetInstrumentTest {
    static RobinhoodApi api = new RobinhoodApi();

    public static void main(String[] args) throws Exception {

        RobinhoodApi api = new RobinhoodApi();

        TickerQuoteElement msft = api.getQuoteByTicker("MSFT");
        System.out.println(
                msft.getSymbol() + "\n" +
                msft.getAskPrice()
        );

        getInstrumentByTicker();
        getAllInstruments();
    }

    static void getInstrumentByTicker()
            throws RobinhoodApiException, TickerNotFoundException {
        InstrumentElement e = api.getInstrumentByTicker("MSFT");
    }

    static void getAllInstruments() throws RobinhoodApiException {
        InstrumentElementList list = RequestManager.getInstance()
                              .makeApiRequest(new GetAllInstruments());
    }

}
