package com.ampro.robinhood.endpoint.option.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Leg {

	private String id;
	private String expiration_date;
	private String option;
	private String option_type;
	private String position;
	private String position_type;
	private String ratio_quantity;
	private String strike_price;
	
	public String getId() {
		return id;
	}
	
	public LocalDate getExpirationDate() {
		return LocalDate.parse(expiration_date);
	}
	
	public String getOptionUrl() {
		return option;
	}
	
	public String getOptionType() {
		return option_type;
	}
	
	public String getPositionUrl() {
		return position;
	}
	
	public String getPositionType() {
		return position_type;
	}
	
	public BigDecimal getRatioQuantity() {
		return new BigDecimal(ratio_quantity);
	}
	
	public BigDecimal getStrikePrice() {
		return new BigDecimal(strike_price);
	}
}
