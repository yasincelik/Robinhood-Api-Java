package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.orders.enums.OrderTransactionType;
import com.ampro.robinhood.endpoint.orders.enums.TimeInForce;
import com.ampro.robinhood.throwables.RobinhoodApiException;

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

    /**
     *
     * @param ticker
     * @param quantity
     * @param orderType
     * @param time
     * @param stopPrice
     * @param config
     * @throws RobinhoodApiException
     * @throws com.ampro.robinhood.throwables.RobinhoodNotLoggedInException
     */
    public MakeMarketStopOrder(String ticker, int quantity,
                               OrderTransactionType orderType, TimeInForce time,
                               float stopPrice, Configuration config)
    throws RobinhoodApiException {
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
        this.addFieldParameter("account", this.config.getAccountUrl());
        this.addFieldParameter("instrument", this.tickerInstrumentUrl);
        this.addFieldParameter("symbol", this.ticker);
        this.addFieldParameter("type", "market");
        this.addFieldParameter("time_in_force", getTimeInForceString(this.time));
        this.addFieldParameter("trigger", "stop");
        this.addFieldParameter("quantity", String.valueOf(this.quantity));
        this.addFieldParameter("side", getOrderSideString(orderType));
        this.addFieldParameter("stop_price", this.stopPrice);
    }

}
