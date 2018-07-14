package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.orders.enums.OrderTransactionType;
import com.ampro.robinhood.endpoint.orders.enums.TimeInForce;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.ampro.robinhood.throwables.TickerNotFoundException;

/**
 * Created by SirensBell on 5/11/2017.
 */
public class MakeLimitStopOrder extends OrderMethod {

    private String ticker;
    private TimeInForce time;
    private float limitPrice;
    private int quantity;
    private OrderTransactionType orderType;
    private float stopPrice;

    private String tickerInstrumentUrl;

    /**
     * TODO
     * @param ticker
     * @param time
     * @param limitPrice
     * @param quantity
     * @param orderType
     * @param stopPrice
     * @param config
     * @throws RobinhoodApiException
     * @throws TickerNotFoundException
     */
    public MakeLimitStopOrder(String ticker, TimeInForce time, float limitPrice,
                              int quantity, OrderTransactionType orderType,
                              float stopPrice, Configuration config)
    throws RobinhoodApiException {
        super(config);
        this.tickerInstrumentUrl = verifyTickerData(ticker);
        this.ticker = ticker;
        this.time = time;
        this.limitPrice = limitPrice;
        this.quantity = quantity;
        this.orderType = orderType;
        this.stopPrice = stopPrice;

        //Set the normal parameters for this endpoint
        setEndpointParameters();

        //Set the order parameters
        setOrderParameters();

    }

    /**
     * Method which sets the URLParameters for correctly so the order is ran as a
     * Limit Buy order, given the settings from the constructor
     */
    private void setOrderParameters() throws RobinhoodApiException {
        //Add the account URL for the currently logged in account
        this.addFieldParameter("account", this.config.getAccountUrl());
        this.addFieldParameter("instrument", this.tickerInstrumentUrl);
        this.addFieldParameter("symbol", this.ticker);
        this.addFieldParameter("type", "limit");
        this.addFieldParameter("time_in_force", getTimeInForceString(this.time));
        this.addFieldParameter("price", this.limitPrice);
        this.addFieldParameter("trigger", "immediate");
        this.addFieldParameter("quantity", String.valueOf(this.quantity));
        this.addFieldParameter("side", getOrderSideString(this.orderType));
    }

}
