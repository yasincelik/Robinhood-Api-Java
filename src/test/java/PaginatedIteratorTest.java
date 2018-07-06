import com.ampro.robinhood.RobinhoodApi;
import com.ampro.robinhood.endpoint.instrument.data.InstrumentElement;
import com.ampro.robinhood.endpoint.instrument.data.InstrumentElementList;
import com.ampro.robinhood.endpoint.instrument.methods.SearchInstrumentsByKeyword;
import com.ampro.robinhood.net.pagination.PaginatedIterator;
import com.ampro.robinhood.net.request.RequestManager;

import java.util.ArrayList;

public class PaginatedIteratorTest {

    public static void main(String[] args) throws Exception {
        RobinhoodApi api = new RobinhoodApi();
        InstrumentElementList list
                = RequestManager.getInstance()
                                .makeApiRequest(new SearchInstrumentsByKeyword("Inc"));

        PaginatedIterator<InstrumentElement> iterator
                = new PaginatedIterator<>(list);
        ArrayList<InstrumentElement> purelist = new ArrayList<>();
        while (iterator.hasNext()) {
            purelist.add(iterator.next());
        }

        System.out.println(purelist.size());

        purelist.forEach(it -> System.out.println(it.getName()));

    }

}
