import com.ampro.robinhood.endpoint.fundamentals.data.TickerFundamentalElement;
import com.ampro.robinhood.endpoint.fundamentals.data.TickerFundimentalElementList;
import com.ampro.robinhood.endpoint.fundamentals.methods.GetTickerFundamental;
import com.ampro.robinhood.endpoint.fundamentals.methods.GetTickerFundimentalList;
import com.ampro.robinhood.endpoint.instrument.data.InstrumentElementList;
import com.ampro.robinhood.endpoint.instrument.methods.GetInstrumentByTicker;
import com.ampro.robinhood.net.request.RequestManager;
import com.ampro.robinhood.throwables.RequestTooLargeException;
import com.ampro.robinhood.throwables.RobinhoodApiException;

import java.util.Arrays;

public class GetFundimentalTest {

    static RequestManager manager = RequestManager.getInstance();

    public static void main(String[] args) throws RobinhoodApiException {
        byTicker();
        try {
            byTickerList();
        } catch (RequestTooLargeException e) {
            e.printStackTrace();
        }
    }

    static void byTicker() throws RobinhoodApiException {
        TickerFundamentalElement msft = manager.makeApiRequest(new GetTickerFundamental("MSFT"));
        assert msft.getDescription() != null;
    }

    static void byTickerList() throws RobinhoodApiException, RequestTooLargeException {
        TickerFundimentalElementList list = manager.makeApiRequest(
                new GetTickerFundimentalList(Arrays.asList(
                        "MSFT", "BAC", "FIT", "OOO", "VT", "VTI", "ITOT", "XLK", "TSLA",
                        "AAPL"
                )
            )
        );
        assert !list.isEmpty();
    }

}
