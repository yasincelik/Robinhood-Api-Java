package com.ampro.robinhood.net.request;

import com.ampro.robinhood.endpoint.RobinhoodEnum;

public enum RequestStatus implements RobinhoodEnum {
	SUCCESS,
	FAILURE,
	NOT_LOGGED_IN;

	private String value;
	RequestStatus() { this.value = null; }
	RequestStatus(String s) { value = s; }

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.value != null ? value : super.toString();
	}

    /**
     * Set the value (and toString) of this enum.
     * @param s The new value
     */
	public RequestStatus setValue(String s) {
	    value = s;
	    return this;
    }
}
