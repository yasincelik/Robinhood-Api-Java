package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.endpoint.orders.OrderMethod;
import com.ampro.robinhood.endpoint.orders.data.SecurityOrderElement;
import com.ampro.robinhood.request.RequestMethod;
import com.ampro.robinhood.throwables.RobinhoodApiException;

/**
 * An API method to cancel an open order.
 * @author Jonathan Augustine
 */
public class CancelOrderMethod extends OrderMethod {

    /**
     * Build a cancel order method.
     * @param order The order to cancel
     * @throws RobinhoodApiException If the order cannot be cancelled
     */
    public CancelOrderMethod(SecurityOrderElement order)
    throws RobinhoodApiException {
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
        this.setUrlBase(order.getCancel().toExternalForm());
        this.setReturnType(SecurityOrderElement.class);
    }

    @Override
    public RequestMethod getMethod() {
        return RequestMethod.POST;
    }

}
