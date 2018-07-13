package com.ampro.robinhood.endpoint.option.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Option {

	private String id;
	private String average_open_price;
	private String chain;
	private String created_at;
	private String direction;
	private String intraday_average_open_price;
	private String intraday_direction;
	private String intraday_quantity;
	private List<Leg> legs;
	private String quantity;
	private String strategy;
	private String symbol;
	private String trade_value_multiplier;
	private String updated_at;
	
	public String getId() {
		return id;
	}
	
	public BigDecimal getAverageOpenPrice() {
		return new BigDecimal(average_open_price);
	}
	
	public String getChainUrl() {
		return chain;
	}
	
	public LocalDateTime getCreatedAt() {
		return LocalDateTime.parse(created_at);
	}
	
	public String getDirection() {
		return direction;
	}
	
	public BigDecimal getIntradayAverageOpenPrice() {
		return new BigDecimal(intraday_average_open_price);
	}
	
	public String getIntradayDirection() {
		return intraday_direction;
	}
	
	public BigDecimal getIntradayQuantity() {
		return new BigDecimal(intraday_quantity);
	}
	
	public List<Leg> getLegs() {
		return legs;
	}
	
	public BigDecimal getQuantity() {
		return new BigDecimal(quantity);
	}
	
	public String getStrategy() {
		return strategy;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public BigDecimal getTradeValueMultiplier() {
		return new BigDecimal(trade_value_multiplier);
	}
	
	public LocalDateTime getUpdatedAt() {
		return LocalDateTime.parse(updated_at);
	}
}
