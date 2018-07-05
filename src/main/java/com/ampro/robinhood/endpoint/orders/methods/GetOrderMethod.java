package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.orders.data.SecurityOrderListElement;
import com.ampro.robinhood.net.parameters.HttpHeaderParameter;
import com.ampro.robinhood.net.request.RequestMethod;

/**
 * REST GET method to retrieve a user's orders.
 * @author Jonathan Augustine
 */
public class GetOrderMethod extends OrderMethod {

    /**
     * Set api URL to GET from & return type ({@link SecurityOrderListElement}).
     */
    public GetOrderMethod(Configuration config) {
        super(config);
        this.setUrlBase("https://api.robinhood.com/orders/");

        this.addHttpHeaderParameter("Content-Type", "application/x-www-form-urlencoded");

        //This method should be ran as POST
        this.setMethod(RequestMethod.GET);

        this.setReturnType(SecurityOrderListElement.class);
    }

}
