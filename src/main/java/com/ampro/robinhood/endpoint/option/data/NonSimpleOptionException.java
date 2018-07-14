package com.ampro.robinhood.endpoint.option.data;

public class NonSimpleOptionException extends RuntimeException {

	private static final long serialVersionUID = 8285526229611506289L;

	public NonSimpleOptionException() {
		super("Option with multiple legs cannot be converted to simple option");
	}
}
