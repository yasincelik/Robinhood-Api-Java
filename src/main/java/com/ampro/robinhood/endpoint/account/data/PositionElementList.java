package com.ampro.robinhood.endpoint.account.data;


import com.ampro.robinhood.endpoint.ApiElement;
import com.ampro.robinhood.throwables.RobinhoodApiException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by SirensBell on 6/19/2017.
 */
public class PositionElementList implements ApiElement {

    /**
     * This is here due to what looks to be an unimplemented feature from the Robinhood team
     */
    private PositionElement[] previous = null;

    /**
     * The list of positions that the user is currently in
     */
    private PositionElement[] results = null;

    /**
     * Get a Vector object containing every position on the account watchlist. You have a position in that stock if
     * the quantity value is above 0
     * @return A vector containing all of the positions of your account
     */
    public List<PositionElement> getPositionList() throws RobinhoodApiException {
        if(results != null) {
            //Return the array as a list for ease-of-use & consistency
            return Arrays.asList(results);
        }
        else
            throw new RobinhoodApiException(
                    "Error retrieving the list of positions"
            );
    }

    @Override
    public boolean requiresAuth() {
        return true;
    }

}
