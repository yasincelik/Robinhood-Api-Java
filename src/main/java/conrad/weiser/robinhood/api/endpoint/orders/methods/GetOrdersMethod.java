package conrad.weiser.robinhood.api.endpoint.orders.methods;

import conrad.weiser.robinhood.api.endpoint.orders.Orders;
import conrad.weiser.robinhood.api.endpoint.orders.data.SecurityOrderListElement;
import conrad.weiser.robinhood.api.parameters.HttpHeaderParameter;
import conrad.weiser.robinhood.api.request.RequestMethod;

/**
 * @author Jonathan Augustine
 */
public class GetOrdersMethod extends Orders {

    /**
     * Set api URL to GET from & return type ({@link SecurityOrderListElement}).
     */
    public GetOrdersMethod() {
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
