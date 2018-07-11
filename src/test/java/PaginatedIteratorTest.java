import com.ampro.robinhood.RobinhoodApi;
import com.ampro.robinhood.endpoint.ApiElement;
import com.ampro.robinhood.endpoint.instrument.data.InstrumentElement;
import com.ampro.robinhood.endpoint.instrument.data.InstrumentElementList;
import com.ampro.robinhood.endpoint.instrument.methods.GetAllInstruments;
import com.ampro.robinhood.net.pagination.PaginatedIterator;
import com.ampro.robinhood.net.request.RequestManager;

import java.util.ArrayList;

public class PaginatedIteratorTest {

    public static void main(String[] args) throws Exception {
        RobinhoodApi api = new RobinhoodApi();
        InstrumentElementList list
                = RequestManager.getInstance()
                                .makeApiRequest(GetAllInstruments.getDefault());

        PaginatedIterator<InstrumentElement> iterator
                = new PaginatedIterator<>(list);
        ArrayList<InstrumentElement> purelist = new ArrayList<>();
        while (iterator.hasNext()) {
            InstrumentElement element = iterator.next();
            System.out.println(element.getName());
            purelist.add(element);
        }

        Iterable<ApiElement> elements = api.buildIterable(list);

        System.out.println(purelist.size());

        purelist.forEach(it -> System.out.println(it.getName()));

    }

}
