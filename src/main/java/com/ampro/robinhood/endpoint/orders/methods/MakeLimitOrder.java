package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.orders.enums.OrderTransactionType;
import com.ampro.robinhood.endpoint.orders.enums.TimeInForce;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.ampro.robinhood.throwables.TickerNotFoundException;

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
	 * Method which sets the URLParameters for correctly so the order is ran as a
	 * Limit Buy order, given the settings from the constructor
	 */
	protected void setOrderParameters() throws RobinhoodApiException {
		//Add the account URL for the currently logged in account
		this.addUrlParameter("account", this.config.getAccountUrl());
		this.addUrlParameter("instrument", this.tickerInstrumentUrl);
		this.addUrlParameter("symbol", this.ticker);
		this.addUrlParameter("type", "limit");
		this.addUrlParameter("time_in_force", getTimeInForceString(this.time));
		this.addUrlParameter("price", this.limitPrice);
		this.addUrlParameter("trigger", "immediate");
		this.addUrlParameter("quantity", String.valueOf(this.quantity));
		this.addUrlParameter("side", getOrderSideString(orderType));
	}

}
