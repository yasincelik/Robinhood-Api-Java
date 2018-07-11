package com.ampro.robinhood.endpoint.orders.wrappers;

import com.ampro.robinhood.endpoint.orders.enums.OrderTrigger;

public class OrderTriggerWrapper {

	private float stopPrice;
	OrderTrigger orderTriggerEnum;

	/**
	 * If the order type is going to be STOP,
	 * require the stop_price for the transaction
	 * @param stopPrice The stop price
	 */
	public OrderTriggerWrapper(float stopPrice) {

		this.stopPrice = stopPrice;
		this.orderTriggerEnum = OrderTrigger.STOP;

	}

	/**
	 * Otherwise, you're creating an IMMEDIATE order.
	 */
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
