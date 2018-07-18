package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.orders.enums.OrderTransactionType;
import com.ampro.robinhood.endpoint.orders.enums.TimeInForce;
import com.ampro.robinhood.throwables.NotLoggedInException;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.ampro.robinhood.throwables.TickerNotFoundException;

/**
 * Created by SirensBell on 6/18/2017.
 */
public class MakeMarketStopOrder extends OrderMethod {

    private final String ticker;
    private final int quantity;
    private final OrderTransactionType orderType;
    private final String tickerInstrumentUrl;
    private final TimeInForce time;
    private final float stopPrice;

    /**
     *
     * @param ticker
     * @param quantity
     * @param orderType
     * @param time
     * @param stopPrice
     * @param config
     * @throws RobinhoodApiException
     * @throws NotLoggedInException
     */
    public MakeMarketStopOrder(String ticker, int quantity,
                               OrderTransactionType orderType, TimeInForce time,
                               float stopPrice, Configuration config)
    throws TickerNotFoundException {
        super(config);
        this.ticker = ticker;
        this.quantity = quantity;
        this.orderType = orderType;
        this.time = time;
        this.stopPrice = stopPrice;

        //Set the normal parameters for this endpoint
        setEndpointParameters();

        //Set the order parameters
        setOrderParameters();

        //Verify the ticker and add it to the instrument URL to be used for later
        this.tickerInstrumentUrl = verifyTickerData(this.ticker);

    }

    /**
     * Method which sets the URLParameters so the order is ran as a
     * Market Stop order, given the settings from the constructor
     */
    private void setOrderParameters() {
        this.addFieldParameter("account", this.config.getAccountUrl());
        this.addFieldParameter("instrument", this.tickerInstrumentUrl);
        this.addFieldParameter("symbol", this.ticker);
        this.addFieldParameter("type", "market");
        this.addFieldParameter("time_in_force", this.time.toString());
        this.addFieldParameter("trigger", "stop");
        this.addFieldParameter("quantity", String.valueOf(this.quantity));
        this.addFieldParameter("side", getOrderSideString(orderType));
        this.addFieldParameter("stop_price", this.stopPrice);
    }

}
