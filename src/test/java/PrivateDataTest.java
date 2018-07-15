import com.ampro.robinhood.RobinhoodApi;
import com.ampro.robinhood.endpoint.orders.data.SecurityOrderElement;
import com.ampro.robinhood.endpoint.orders.data.SecurityOrderElementList;
import com.ampro.robinhood.endpoint.orders.methods.GetOrdersMethod;
import com.ampro.robinhood.net.request.RequestManager;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.ampro.robinhood.throwables.RobinhoodNotLoggedInException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class PrivateDataTest extends DataTest {

    @Override
    public void init() throws Exception {
        super.init();
        File file = new File("config.txt");
        if (!file.canRead())
            throw new RobinhoodNotLoggedInException("Requires a login config.");
        List<String> lines = Files.readAllLines(file.toPath());
        api = new RobinhoodApi(lines.get(0), lines.get(1));
    }

    @Test
    public void getOrders() throws RobinhoodApiException {
        List<SecurityOrderElement> orders = api.getOrders();
        assertNotNull(orders);
        orders.forEach(Assert::assertNotNull);
    }
}
