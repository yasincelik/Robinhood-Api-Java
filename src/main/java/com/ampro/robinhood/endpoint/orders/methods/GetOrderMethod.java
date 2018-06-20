package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.endpoint.orders.OrderMethod;
import com.ampro.robinhood.endpoint.orders.data.SecurityOrderListElement;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.request.RequestMethod;

/**
 * REST GET method to retrieve a user's orders.
 * @author Jonathan Augustine
 */
public class GetOrderMethod extends OrderMethod {

    /**
     * Set api URL to GET from & return type ({@link SecurityOrderListElement}).
     */
    public GetOrderMethod() {
        this.setUrlBase("https://api.robinhood.com/orders/");

        //Add the send-receive headers into the request
        this.addHttpHeaderParameter(
                new HttpHeaderParameter("Accept", "application/json")
        );
        this.addHttpHeaderParameter(
                new HttpHeaderParameter("Content-Type", "application/x-www-form-urlencoded")
        );

        //This method should be ran as POST
        this.setMethod(RequestMethod.GET);

        this.setReturnType(SecurityOrderListElement.class);
    }

    @Override
    public RequestMethod getMethod() {
        return RequestMethod.GET;
    }

}
