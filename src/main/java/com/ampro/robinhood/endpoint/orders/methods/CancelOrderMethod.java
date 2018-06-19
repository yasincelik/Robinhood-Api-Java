package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.endpoint.orders.Orders;
import com.ampro.robinhood.request.RequestMethod;

/**
 * TODO
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
