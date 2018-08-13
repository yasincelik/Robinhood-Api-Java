package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.orders.data.SecurityOrder;
import com.ampro.robinhood.net.request.RequestMethod;

/**
 * Get an up-to-date {@link SecurityOrder} by ID, URL, or an old instance of the
 * same order.
 *
 * @author Jonathan Augustine
 * @since 0.8.4
 */
public class GetOrderMethod extends OrderMethod {

    public GetOrderMethod(String id, Configuration config) {
        super(config);
        setUrlBase(RH_URL + "/orders/{id}");
        addRouteParameter("id", id);
        setMethodType(RequestMethod.GET);
    }

    public GetOrderMethod(SecurityOrder order, Configuration config) {
        this(order.getId(), config);
    }

}
