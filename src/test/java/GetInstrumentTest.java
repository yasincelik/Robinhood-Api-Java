import com.ampro.robinhood.RobinhoodApi;
import com.ampro.robinhood.endpoint.instrument.data.InstrumentElement;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.ampro.robinhood.throwables.TickerNotFoundException;

public class GetInstrumentTest {
    static RobinhoodApi api = new RobinhoodApi();

    public static void main(String[] args) throws Exception {
        getInstrumentByTicker();
    }

    static void getInstrumentByTicker()
            throws RobinhoodApiException, TickerNotFoundException {
        InstrumentElement e = api.getInstrumentByTicker("MSFT");
    }

}
