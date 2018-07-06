package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.orders.data.SecurityOrderElement;
import com.ampro.robinhood.net.request.RequestMethod;
import com.ampro.robinhood.throwables.RobinhoodApiException;

/**
 * An API method to cancel an open order.
 * TODO ****XXX THIS IS UNFINISHED AND SHOULD NOT BE USED XXX***
 * @author Jonathan Augustine
 */
public class CancelOrderMethod extends OrderMethod {

    /**
     * Build a cancel order method.
     * @param order The order to cancel
     * @throws RobinhoodApiException If the order cannot be cancelled
     */
    public CancelOrderMethod(SecurityOrderElement order, Configuration config)
    throws RobinhoodApiException {
        super(config);
        switch (order.getTransactionState()) {
            case CONFIRMED:
            case QUEUED:
            case UNCONFIRMED:
                break;
            default:
                throw new RobinhoodApiException(
                        "Closed order cannot be cancelled."
                );
        }
        if (order.getCancel() == null) {
            throw new RobinhoodApiException("Order cancel is null.");
        }
        this.setMethodType(RequestMethod.POST);
        this.setUrlBase(order.getCancel().toExternalForm());
        this.setReturnType(SecurityOrderElement.class);
    }

}
