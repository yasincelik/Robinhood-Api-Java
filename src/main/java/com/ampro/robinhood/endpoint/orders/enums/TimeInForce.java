package com.ampro.robinhood.endpoint.orders.enums;

/**
 * Time attribute of an order (how long, when)
 * @author Conrad Weiser, modified-by Jonathan Augustine
 */
public enum TimeInForce {
	GOOD_FOR_DAY,
	GOOD_UNTIL_CANCELED,
	IMMEDIATE_OR_CANCEL,
	FILL_OR_KILL,
	ON_MARKET_OPEN
}
