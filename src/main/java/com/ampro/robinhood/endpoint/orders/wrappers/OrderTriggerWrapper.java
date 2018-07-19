package com.ampro.robinhood.endpoint.orders.wrappers;

import com.ampro.robinhood.endpoint.orders.enums.OrderTrigger;

/**
 * @since 0.6 this class is never used and after testing will be deleted
 * - Jonathan Augustine
 */
public class OrderTriggerWrapper {

	private float stopPrice;
	private final OrderTrigger orderTriggerEnum;

	/**
	 * If the order type is going to be STOP,
	 * require the stop_price for the transaction
	 *
	 * @param stopPrice The stop price
	 */
	public OrderTriggerWrapper(float stopPrice) {
		this.stopPrice = stopPrice;
		this.orderTriggerEnum = OrderTrigger.STOP;
	}

	/** A Wrapper for an immediate OrderTrigger. */
	public OrderTriggerWrapper() {
		this.orderTriggerEnum = OrderTrigger.IMMEDIATE;
	}

	public float getStopPrice() {
		return stopPrice;
	}

	public OrderTrigger getOrderTriggerEnum() {
		return this.orderTriggerEnum;
	}

}
