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

    private final String ticker;
    private final TimeInForce time;
    private final float limitPrice;
    private final int quantity;
    private final OrderTransactionType orderType;
    private final String tickerInstrumentUrl;
    private final float stopPrice;

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
    throws TickerNotFoundException {

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
     *
     * @throws com.ampro.robinhood.throwables.NotLoggedInException
     */
    private void setOrderParameters() {
        //Add the account URL for the currently logged in account
        this.addFieldParameter("account", this.config.getAccountUrl());
        this.addFieldParameter("instrument", this.tickerInstrumentUrl);
        this.addFieldParameter("symbol", this.ticker);
        this.addFieldParameter("type", "limit");
        this.addFieldParameter("time_in_force", this.time.toString());
        this.addFieldParameter("price", this.limitPrice);
        this.addFieldParameter("stop_price", this.stopPrice);
        this.addFieldParameter("trigger", "stop");
        this.addFieldParameter("quantity", String.valueOf(this.quantity));
        this.addFieldParameter("side", getOrderSideString(this.orderType));
    }

}
