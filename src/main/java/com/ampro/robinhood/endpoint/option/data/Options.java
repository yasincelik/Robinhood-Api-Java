package com.ampro.robinhood.endpoint.option.data;

import java.util.ArrayList;
import java.util.List;

public class Options {

	private final List<Option> results;
	
	public Options() {
		results = new ArrayList<>();
	}

	public List<Option> getResults() {
		return results;
	}
}
