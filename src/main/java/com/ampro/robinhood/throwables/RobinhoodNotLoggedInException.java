package com.ampro.robinhood.throwables;

/**
 * Thrown when an unauthorized instance tries to get account data
 *
 */
@SuppressWarnings("serial")
public class RobinhoodNotLoggedInException extends RobinhoodApiException {

    public RobinhoodNotLoggedInException() {
        super();
    }

    public RobinhoodNotLoggedInException(String message) {
        super(message);
    }

    /**
     * Override the default method to get more information about why the error
     * is thrown
     * @return more information about the exception
     */
    @Override
    public String getMessage() {
        return "There is no Token available. " +
                "Make sure that the login method is being used first.";

    }

}
