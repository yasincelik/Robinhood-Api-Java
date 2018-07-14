package com.ampro.robinhood.util;

import java.time.format.DateTimeFormatter;

public final class ChronoFormatter {

	private ChronoFormatter() {}
	
	public static DateTimeFormatter getFormat() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSX");
	}
}
