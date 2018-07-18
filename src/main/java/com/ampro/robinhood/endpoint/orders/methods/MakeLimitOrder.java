package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.orders.enums.OrderTransactionType;
import com.ampro.robinhood.endpoint.orders.enums.TimeInForce;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.ampro.robinhood.throwables.TickerNotFoundException;

public class MakeLimitOrder extends OrderMethod {

	private final String ticker;
	private final TimeInForce time;
	private final float limitPrice;
	private final int quantity;
	private final OrderTransactionType orderType;

	private String tickerInstrumentUrl;

	/**
	 * TODO
	 * @param ticker
	 * @param time
	 * @param limitPrice
	 * @param quantity
	 * @param orderType
	 * @param config
	 * @throws RobinhoodApiException
	 * @throws TickerNotFoundException
	 */
	public MakeLimitOrder(String ticker, TimeInForce time, float limitPrice,
	                      int quantity, OrderTransactionType orderType,
	                      Configuration config)
    throws TickerNotFoundException {
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
	 * @throws com.ampro.robinhood.throwables.NotLoggedInException
     *              If the {@link Configuration} is not logged in
	 */
	protected void setOrderParameters() {
		//Add the account URL for the currently logged in account
		this.addFieldParameter("account", this.config.getAccountUrl());
		this.addFieldParameter("instrument", this.tickerInstrumentUrl);
		this.addFieldParameter("symbol", this.ticker);
		this.addFieldParameter("type", "limit");
		this.addFieldParameter("time_in_force", this.time.toString());
		this.addFieldParameter("price", this.limitPrice);
		this.addFieldParameter("trigger", "immediate");
		this.addFieldParameter("quantity", String.valueOf(this.quantity));
		this.addFieldParameter("side", getOrderSideString(orderType));
	}

}
