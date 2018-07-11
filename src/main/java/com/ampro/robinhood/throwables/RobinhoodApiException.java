package com.ampro.robinhood.throwables;

@SuppressWarnings("serial")
public class RobinhoodApiException extends Exception {

	private final String error;

	public RobinhoodApiException() {
	    this.error = null;
	}

	public RobinhoodApiException(String errorMessage) {
		this.error = errorMessage;
	}

	@Override
	public String getMessage() {
		return this.error == null
                ? "A problem has occured within the Robinhood API library"
                : this.error;
	}

}
