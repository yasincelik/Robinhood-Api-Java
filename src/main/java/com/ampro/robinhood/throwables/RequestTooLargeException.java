package com.ampro.robinhood.throwables;

/**
 * An exception for API requests that are too large (ala get w/ 10000 items).
 * @author Jonathan Augustine
 */
public class RequestTooLargeException extends Exception {
    public RequestTooLargeException() {
        super();
    }

    public RequestTooLargeException(String message) {
        super(message);
    }
}
