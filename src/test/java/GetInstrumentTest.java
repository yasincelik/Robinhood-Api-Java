import com.ampro.robinhood.RobinhoodApi;
import com.ampro.robinhood.endpoint.instrument.data.InstrumentElement;
import com.ampro.robinhood.endpoint.instrument.data.InstrumentElementList;
import com.ampro.robinhood.endpoint.instrument.methods.GetAllInstruments;
import com.ampro.robinhood.net.request.RequestManager;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.ampro.robinhood.throwables.TickerNotFoundException;

public class GetInstrumentTest {
    static RobinhoodApi api = new RobinhoodApi();

    public static void main(String[] args) throws Exception {
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
