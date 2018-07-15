package com.ampro.robinhood.endpoint.option.methods;

import static com.ampro.robinhood.test.RobinhoodAssertions.assertDateEquals;
import static com.ampro.robinhood.test.RobinhoodAssertions.assertDateTimeEquals;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.ZoneOffset;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.option.data.Option;
import com.ampro.robinhood.endpoint.option.data.Options;
import com.ampro.robinhood.net.ApiMethod;
import com.ampro.robinhood.net.request.RequestManager;
import com.ampro.robinhood.throwables.RobinhoodApiException;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

public class GetOptionsMethodIntegrationTest {
	
	@Rule
	public WireMockRule wireMockRule = new WireMockRule();
	
	private RequestManager requestManager;
	private Option firstOption;
	
	@Before
	public void setUp() throws Exception {
		requestManager = RequestManager.getInstance();
		
		wireMockRule.stubFor(get(urlEqualTo("/options/aggregate_positions/"))
	        .willReturn(aResponse()
	        	.withStatus(200)
	            .withBody("{\"previous\":null,\"results\":[{\"created_at\":\"2018-07-11T14:01:00.509277Z\","
	            	+ "\"direction\":\"debit\",\"intraday_quantity\":\"0.0000\",\"average_open_price\":\"12.0000\","
	            	+ "\"chain\":\"https://api.robinhood.com/options/chains/5c79042f-4f8a-4bfd-9056-8546893c69ae/\","
	            	+ "\"updated_at\":\"2018-07-11T14:01:00.518885Z\",\"symbol\":\"MU\","
	            	+ "\"trade_value_multiplier\":\"100.0000\",\"intraday_direction\":\"debit\","
	            	+ "\"strategy\":\"long_call\",\"intraday_average_open_price\":\"0.0000\","
	            	+ "\"legs\":[{\"strike_price\":\"70.0000\","
	            	+ "\"option\":\"https://api.robinhood.com/options/instruments/278c0d83-6a88-4d76-accb-a4e8ac626379/\","
	            	+ "\"expiration_date\":\"2018-08-17\",\"option_type\":\"call\",\"id\":\"827e06a6-1b9f-4941-bb72-32ce220736fd\","
	            	+ "\"position_type\":\"long\","
	            	+ "\"position\":\"https://api.robinhood.com/options/positions/5b2c2524-d149-4865-a0d9-3db99d5ef2b8/\","
	            	+ "\"ratio_quantity\":1}],\"id\":\"9182928a-f780-4043-a307-d04e9d07ad3b\",\"quantity\":\"2.0000\"}]}")
	            ));
		
		firstOption = getOptions().getResults().get(0);
	}

	private Options getOptions() throws RobinhoodApiException {
		ApiMethod method = new GetOptionsMethod(Configuration.getDefault(), "http://localhost:8080");
		return requestManager.makeApiRequest(method);
	}

	@Test
	public void correctlyParseCreatedAt() throws Exception {
		assertDateTimeEquals(2018, 7, 11, 14, 1, 0, 509277000, ZoneOffset.UTC, firstOption.getCreatedAt());
	}
	
	@Test
	public void correctlyParseDirection() throws Exception {
		assertEquals("debit", firstOption.getDirection());
	}
	
	@Test
	public void correctlyParseIntradayQuantity() throws Exception {
		assertEquals(new BigDecimal("0.0000"), firstOption.getIntradayQuantity());
	}
	
	@Test
	public void correctlyParseAverageOpenPrice() throws Exception {
		assertEquals(new BigDecimal("12.0000"), firstOption.getAverageOpenPrice());
	}
	
	@Test
	public void correctlyParseChainUrl() throws Exception {
		assertEquals("https://api.robinhood.com/options/chains/5c79042f-4f8a-4bfd-9056-8546893c69ae/", firstOption.getChainUrl());
	}

	@Test
	public void correctlyParseUpdatedAt() throws Exception {
		assertDateTimeEquals(2018, 7, 11, 14, 1, 0, 518885000, ZoneOffset.UTC, firstOption.getUpdatedAt());
	}
	
	@Test
	public void correctlyParseSymbol() throws Exception {
		assertEquals("MU", firstOption.getSymbol());
	}
	
	@Test
	public void correctlyParseTradeValueMultiplier() throws Exception {
		assertEquals(new BigDecimal("100.0000"), firstOption.getTradeValueMultiplier());
	}
	
	@Test
	public void correctlyParseIntradayDirection() throws Exception {
		assertEquals("debit", firstOption.getIntradayDirection());
	}
	
	@Test
	public void correctlyParseStrategy() throws Exception {
		assertEquals("long_call", firstOption.getStrategy());
	}
	
	@Test
	public void correctlyParseIntradayAverageOpenPrice() throws Exception {
		assertEquals(new BigDecimal("0.0000"), firstOption.getIntradayAverageOpenPrice());
	}
	
	@Test
	public void correctlyParseFirstLegStrikePrice() throws Exception {
		assertEquals(new BigDecimal("70.0000"), firstOption.getLegs().get(0).getStrikePrice());
	}
	
	@Test
	public void correctlyParseFirstLegOptionUrl() throws Exception {
		assertEquals("https://api.robinhood.com/options/instruments/278c0d83-6a88-4d76-accb-a4e8ac626379/", firstOption.getLegs().get(0).getOptionUrl());
	}
	
	@Test
	public void correctlyParseFirstLegExpirationDate() throws Exception {
		assertDateEquals(2018, 8, 17, firstOption.getLegs().get(0).getExpirationDate());
	}
	
	@Test
	public void correctlyParseFirstLegOptionType() throws Exception {
		assertEquals("call", firstOption.getLegs().get(0).getOptionType());
	}
	
	@Test
	public void correctlyParseFirstLegId() throws Exception {
		assertEquals("827e06a6-1b9f-4941-bb72-32ce220736fd", firstOption.getLegs().get(0).getId());
	}
	
	@Test
	public void correctlyParseFirstLegPositionType() throws Exception {
		assertEquals("long", firstOption.getLegs().get(0).getPositionType());
	}
	
	@Test
	public void correctlyParseFirstLegPositionUrl() throws Exception {
		assertEquals("https://api.robinhood.com/options/positions/5b2c2524-d149-4865-a0d9-3db99d5ef2b8/", firstOption.getLegs().get(0).getPositionUrl());
	}
	
	@Test
	public void correctlyParseFirstLegRatioQuantity() throws Exception {
		assertEquals(new BigDecimal("1"), firstOption.getLegs().get(0).getRatioQuantity());
	}
	
	@Test
	public void correctlyParseId() throws Exception {
		assertEquals("9182928a-f780-4043-a307-d04e9d07ad3b", firstOption.getId());
	}
	
	@Test
	public void correctlyParseQuantity() throws Exception {
		assertEquals(new BigDecimal("2.0000"), firstOption.getQuantity());
	}
}
