package com.ampro.robinhood.throwables;

/**
 * An exception to be thrown when a ticker is not found after polling Robinhood
 * @author Jonathan Augustine
 */
public class TickerNotFoundException extends Exception {
    private String ticker;

    public TickerNotFoundException() {
        super();
        this.ticker = "";
    }

    public TickerNotFoundException(String message) {
        super(message);
        this.ticker = "";
    }

    public TickerNotFoundException(String ticker, String message) {
        super(message);
        this.ticker = ticker;
    }

    public TickerNotFoundException with(String ticker) {
        this.ticker = ticker;
        return this;
    }
}
