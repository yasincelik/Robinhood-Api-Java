package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.orders.enums.OrderTransactionType;
import com.ampro.robinhood.endpoint.orders.enums.TimeInForce;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.ampro.robinhood.throwables.TickerNotFoundException;
import com.ampro.robinhood.throwables.RobinhoodNotLoggedInException;

public class MakeLimitOrder extends OrderMethod {

	private String ticker;
	private TimeInForce time;
	private float limitPrice;
	private int quantity;
	private OrderTransactionType orderType;

	private String tickerInstrumentUrl;

	public MakeLimitOrder(String ticker, TimeInForce time, float limitPrice,
	                      int quantity, OrderTransactionType orderType,
	                      Configuration config)
    throws RobinhoodApiException, TickerNotFoundException {
        super(config);
        this.ticker = ticker;
        this.time = time;
        this.limitPrice = limitPrice;
        this.quantity = quantity;
        this.orderType = orderType;

        //Set the normal parameters for this endpoint
        setEndpointParameters();

        //Set the order parameters
        setOrderParameters();

        //Verify the ticker, and add the instrument URL to be used for later
        this.tickerInstrumentUrl = verifyTickerData(this.ticker);

    }

	/**
	 * Method which sets the URLParameters for correctly so the order is ran as
	 * a Limit Buy order, given the settings from the constructor
	 * @throws RobinhoodApiException
	 * @throws RobinhoodNotLoggedInException If the {@link Configuration} is
	 *              not logged in
	 */
	protected void setOrderParameters() throws RobinhoodApiException {
		//Add the account URL for the currently logged in account
		this.addFieldParameter("account", this.config.getAccountUrl());
		this.addFieldParameter("instrument", this.tickerInstrumentUrl);
		this.addFieldParameter("symbol", this.ticker);
		this.addFieldParameter("type", "limit");
		this.addFieldParameter("time_in_force", getTimeInForceString(this.time));
		this.addFieldParameter("price", this.limitPrice);
		this.addFieldParameter("trigger", "immediate");
		this.addFieldParameter("quantity", String.valueOf(this.quantity));
		this.addFieldParameter("side", getOrderSideString(orderType));
	}

}
