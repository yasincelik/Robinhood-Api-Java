package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.fundamentals.data.TickerFundamentalElement;
import com.ampro.robinhood.endpoint.fundamentals.methods.GetTickerFundamental;
import com.ampro.robinhood.endpoint.orders.data.SecurityOrderElement;
import com.ampro.robinhood.endpoint.orders.enums.OrderTransactionType;
import com.ampro.robinhood.net.ApiMethod;
import com.ampro.robinhood.net.request.RequestManager;
import com.ampro.robinhood.net.request.RequestMethod;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.ampro.robinhood.throwables.TickerNotFoundException;

public class OrderMethod extends ApiMethod {

	protected OrderMethod(Configuration config) {
		super(config);
	}

	/**
	 * Method which sets up the basic parameters for the endpoint.
	 * This does not include the order data.
	 */
	protected void setEndpointParameters() {

		this.setUrlBase("https://api.robinhood.com/orders/");

		this.addHeaderParameter("Content-Type", "application/x-www-form-urlencoded");

		//This method should be ran as POST
		this.setMethodType(RequestMethod.POST);

		this.setReturnType(SecurityOrderElement.class);
	}

	/**
	 * Method which parses the Order Side enum value.
	 * This should only return BUY or SELL
	 *
	 * @param transactionType buy or sell
	 */
	protected String getOrderSideString(OrderTransactionType transactionType)
    throws RobinhoodApiException {
        switch (transactionType) {
            case BUY: return "buy";
            case SELL: return "sell";
            default:
                throw new RobinhoodApiException(
                        "[Robinhood API] ERROR - Order Side parsing failed. " +
                                "You shouldn't see this. Please file a bug " +
                                "report on github!"
                );
        }

    }

	/**
	 * Verifies that the ticker is a valid one. If not, throw an error. This
	 * method also supplies additional information of the Ticker symbol that
	 * the order class is required to use.
	 * @return InstrumentURL to the class to be used in the request
	 * @throws RobinhoodApiException
	 * @throws TickerNotFoundException
	 */
	protected String verifyTickerData(String ticker)
	throws RobinhoodApiException, TickerNotFoundException {

		//Make a Ticker Fundamental API request for the supplied ticker
		RequestManager requestManager = RequestManager.getInstance();

		ApiMethod method = new GetTickerFundamental(ticker);

		TickerFundamentalElement response = requestManager.makeApiRequest(method);

		//Does the ticker have a valid Instrument URL?
        //If not, this ticker is invalid. Throw an error.
		if (response.getInstrument() == null)
			throw new TickerNotFoundException();

		//Otherwise, supply the InstrumentURL to the class to be used in the request
		return response.getInstrument().toString();

	}

}




