package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.orders.enums.OrderTransactionType;
import com.ampro.robinhood.endpoint.orders.enums.TimeInForce;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.ampro.robinhood.throwables.TickerNotFoundException;

/**
 * Created by SirensBell on 6/18/2017.
 */
public class MakeMarketStopOrder extends OrderMethod {

    private String ticker;
    private int quantity;
    private OrderTransactionType orderType;
    private String tickerInstrumentUrl;
    private TimeInForce time;
    private float stopPrice;

    public MakeMarketStopOrder(String ticker, int quantity,
                               OrderTransactionType orderType, TimeInForce time,
                               float stopPrice, Configuration config)
    throws RobinhoodApiException, TickerNotFoundException {
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
    private void setOrderParameters() throws RobinhoodApiException {
        this.addUrlParameter("account", this.config.getAccountUrl());
        this.addUrlParameter("instrument", this.tickerInstrumentUrl);
        this.addUrlParameter("symbol", this.ticker);
        this.addUrlParameter("type", "market");
        this.addUrlParameter("time_in_force", getTimeInForceString(this.time));
        this.addUrlParameter("trigger", "stop");
        this.addUrlParameter("quantity", String.valueOf(this.quantity));
        this.addUrlParameter("side", getOrderSideString(orderType));
        this.addUrlParameter("stop_price", this.stopPrice);
    }

}
