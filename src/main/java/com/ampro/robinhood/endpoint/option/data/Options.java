package com.ampro.robinhood.endpoint.option.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstraction representing a set of options returned from the
 * {@code /options/...} Robinhood Representational State Transfer (REST)
 * endpoints. This abstraction is only intended to wrap the results of a
 * Robinhood request and should not be used directly. In order to obtain the
 * {@link Option} objects associated with this response, use the
 * {@link Options#getResults()} method.
 * 
 * @author <a href="https://github.com/albanoj2">Justin Albano</a>
 * 
 * @since 0.8.2
 */
public class Options {

	private final List<Option> results;

	public Options() {
		results = new ArrayList<>();
	}

	public List<Option> getResults() {
		return results;
	}
}
