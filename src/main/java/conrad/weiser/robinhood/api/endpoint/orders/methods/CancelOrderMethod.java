package conrad.weiser.robinhood.api.endpoint.orders.methods;

import conrad.weiser.robinhood.api.endpoint.orders.Orders;
import conrad.weiser.robinhood.api.request.RequestMethod;

/**
 * @author Jonathan Augustine
 */
public class CancelOrderMethod extends Orders {

    public CancelOrderMethod(String orderId) {

    }

    @Override
    public RequestMethod getMethod() {
        return RequestMethod.POST;
    }

}
