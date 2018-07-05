package com.ampro.robinhood;

import com.ampro.robinhood.throwables.RobinhoodNotLoggedInException;

/**
 * Method which stores the current configuration for the library.
 * The authentication key used for most of the other functions is stored here.
 *
 * @author Jonathan Augustine
 */
public class Configuration {

	/** How long should the system wait between requests? (milisec)*/
	private static long rateLimitValue = 2000;

	/** The authentication token for the logged in user, if one exists */
	private String authToken;

	/**
	 * The Account Number for the account logged in. This variable is used for
     * various other functions.
	 */
	private String accountNumber;

	/**
	 * The Account URL for the account logged in. This variable is required to
     * run a lot of the order requests.
	 */
	private String accountUrl;

	/** The default Config (to reduce repeated allocations for non-auth methods) */
	private static final Configuration defaultConfig = new Configuration();

	/**
	 * Method which gets the saved authorization token if the user is logged in.
	 * If one does not exist, it throws an error reminding the user to run the
     * login functions
	 * first.
	 *
	 * @return the saved Token for the logged in user
	 * @throws RobinhoodNotLoggedInException if there is no stored Token. This must be populated by the setToken() method first
	 */
	public String getToken() throws RobinhoodNotLoggedInException {
		if(authToken == null)
			throw new RobinhoodNotLoggedInException();

		return this.authToken;
	}

	/**
	 * Method which registers the authToken for the user into the Configuration Manager
	 *
	 * @param token verified Authorization Token for the user
	 */
	public void setAuthToken(String token) {
		this.authToken = token;
	}

	/**
	 * Method returning the current ratelimit.
	 * By default, this is 500 milliseconds (.5 seconds)
	 */
	public long getRatelimit() {
		return this.rateLimitValue;
	}

	/**
	 * Set a new ratelimit (in milliseconds)
	 */
	public void setRatelimit(int newRateLimitValue) {
		this.rateLimitValue = newRateLimitValue;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Method returning the Account URL for the logged in user. This is created by appending the account number
	 * to a base URL. This is valid in most order requests
	 * @return the account URL
	 */
	public String getAccountUrl() {
		return "https://api.robinhood.com/accounts/" + this.accountNumber + "/";
	}

	public static Configuration getDefault() { return defaultConfig; }

}
