package com.ampro.robinhood.endpoint.account.data;

import com.ampro.robinhood.endpoint.ApiElement;

/**
 * This element should not exist for very long hopefully as Robinhood updates
 * their API. Currently the getAccounts command returns the data inside of an
 * array after a "next" and "previous" field which are never filled out. This
 * class should never be accessed directly, as it merely is filtered out
 * pulling the only account from the results. Gson needs this in order to
 * work, though.
 */
public class AccountArrayWrapper implements ApiElement {

	private String next;
	private String previous;

	/** The Account element within the JSON response */
	private AccountElement[] results;

	/**
	 * Currently, there will NEVER be more than just one of these.
     * To make it easy for the user to use the methods requiring
	 * this, we only return the existing data.
	 * @return The {@link AccountElement} within the result.
	 */
	public AccountElement getResult() {
		return results[0];
	}

    /**
     * Does nothing
     * @return Nothing
     */
    @Deprecated
    public String getNext() {
        return next;
    }
    /**
     * Does nothing
     * @return Nothing
     */
    @Deprecated
    public String getPrevious() {
        return previous;
    }

    /**
     * @return If the element requires an authorized API (i.e. Is user-specific
     * data)
     */
    @Override
    public boolean requiresAuth() {
        return true;
    }
}
