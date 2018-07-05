package com.ampro.robinhood.endpoint.account.data;


import com.ampro.robinhood.ApiMethod;
import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.ApiElement;
import com.ampro.robinhood.endpoint.fundamentals.data.InstrumentFundamentalElement;
import com.ampro.robinhood.endpoint.fundamentals.methods.GetInstrumentFundamental;
import com.ampro.robinhood.net.request.RequestManager;
import com.ampro.robinhood.throwables.RobinhoodApiException;

/**
 * Element containing information of a given position which exists on a users watchlist.
 */
public class PositionElement implements ApiElement {


    private float shares_held_for_stock_grants;
    private float intraday_quantity;
    private float intraday_average_buy_price;

    //TODO: created_at and updated_at

    private float shares_held_for_buys;
    private float average_buy_price;
    private float shares_held_for_sells;
    private float quantity;

    private String instrument;

    @Override
    public boolean requiresAuth() { return true; }


    public float getShares_held_for_stock_grants() {
        return shares_held_for_stock_grants;
    }

    public float getIntraday_quantity() {
        return intraday_quantity;
    }

    public float getIntraday_average_buy_price() {
        return intraday_average_buy_price;
    }

    public float getShares_held_for_buys() {
        return shares_held_for_buys;
    }

    public float getAverage_buy_price() {
        return average_buy_price;
    }

    public float getShares_held_for_sells() {
        return shares_held_for_sells;
    }

    public float getQuantity() {
        return quantity;
    }

    public String getStockName() {

        ApiMethod method = new GetInstrumentFundamental(this.instrument);
        InstrumentFundamentalElement element;

        try {

            element = RequestManager.getInstance().makeApiRequest(method);
            return element.getStockName();

        } catch (RobinhoodApiException e) {

            return "";

        }

    }

    public String getStockTicker() {

        ApiMethod method = new GetInstrumentFundamental(this.instrument);
        InstrumentFundamentalElement element;

        try {

            element = RequestManager.getInstance().makeApiRequest(method);
            return element.getSymbol();

        } catch (RobinhoodApiException e) {

            return "";

        }

    }


}
