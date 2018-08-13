package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.fundamentals.data.TickerFundamental;
import com.ampro.robinhood.endpoint.fundamentals.methods.GetTickerFundamental;
import com.ampro.robinhood.endpoint.orders.data.SecurityOrder;
import com.ampro.robinhood.net.ApiMethod;
import com.ampro.robinhood.net.request.RequestMethod;
import com.ampro.robinhood.throwables.NotLoggedInException;
import com.ampro.robinhood.throwables.TickerNotFoundException;

/**
 * Base method to send an order to the RH API.
 *
 * @author Conrad Weiser, Jonathan Augustine
 */
public abstract class OrderMethod extends ApiMethod {

	protected OrderMethod(Configuration config) {
		super(config);
		this.addAuthTokenParameter();
        this.addHeaderParameter("Content-Type", "application/x-www-form-urlencoded");
        this.setReturnType(SecurityOrder.class);
	}

    /**
     * Method which sets the URLParameters for the order.
     * Used for cleanliness.
     * @throws NotLoggedInException if calling instance is not logged in
     */
	protected void setOrderParameters() {}

	/**
	 * Method which sets up the basic parameters for the endpoint.
	 * This does not include the order data.
	 */
	protected void setDefaultParameters() {
		this.setUrlBase(RH_URL + "/orders/");
		//Defaults to post
		this.setMethodType(RequestMethod.POST);
	}

	/**
	 * Verifies that the ticker is a valid one. If not, throw an error. This
	 * method also supplies additional information of the Ticker symbol that
	 * the order class is required to use.
	 *
	 * @param ticker The ticker to verify
	 * @return InstrumentURL to the class to be used in the request
	 * @throws TickerNotFoundException If the ticker was not found
	 */
	protected String verifyTickerData(String ticker)
	throws TickerNotFoundException {
		//Make a Ticker Fundamental API request for the supplied ticker
		TickerFundamental response = new GetTickerFundamental(ticker).execute();

		//Does the ticker have a valid Instrument URL?
        //If not, this ticker is invalid. Throw an error.
		//TODO Remove this exception and just return null
		if (response.getInstrument() == null) {
			throw new TickerNotFoundException();
		}

		//Otherwise, supply the InstrumentURL to the class to be used in the request
		return response.getInstrument().toString();
	}

}




