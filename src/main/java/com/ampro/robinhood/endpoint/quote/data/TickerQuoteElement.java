package com.ampro.robinhood.endpoint.quote.data;

/**
 * Created by SirensBell on 6/19/2017.
 */
public class TickerQuoteElement {

    private float ask_price;
    private int ask_size;
    private float bid_price;
    private int big_size;

    private float last_trade_price;
    private float last_extended_hours_trade_price;

    private float previous_close;
    private float adjusted_previous_close;
    private String previous_close_date;
    private String symbol;
    private boolean trading_halted;
    private String updated_at;

    public float getAskPrice() {
        return ask_price;
    }

    public int getAskSize() {
        return ask_size;
    }

    public float getBidPrice() {
        return bid_price;
    }

    public int getBigSize() {
        return big_size;
    }

    public float getLastTradePrice() {
        return last_trade_price;
    }

    public float getLastExtendedHoursTradePrice() {
        return last_extended_hours_trade_price;
    }

    public float getPreviousClose() {
        return previous_close;
    }

    public float getAdjustedPreviousClose() {
        return adjusted_previous_close;
    }

    public String getPreviousCloseDate() {
        return previous_close_date;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isTradingHalted() {
        return trading_halted;
    }

    public String getUpdatedAt() {
        return updated_at;
    }

}
