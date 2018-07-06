package com.ampro.robinhood.endpoint.account.data;


import com.ampro.robinhood.endpoint.ApiElementList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * A paginated list of a user's positions
 * @author Jonathan Augustine
 */
public class PositionElementList extends ApiElementList<PositionElement> {

    @SerializedName("previous")
    @Expose
    private String previous;

    @SerializedName("next")
    @Expose
    private String next;

    /** The list of positions that the user is currently in */
    private List<PositionElement> results;

    @Override
    public List<PositionElement> getResults() { return results; }

    /** @return The URL returned to get the next paginated list */
    @Override
    public String getNext() { return next; }

    /** @return The URL returned to get the previous paginated list */
    @Override
    public String getPrevious() { return previous; }

    @Override
    public boolean requiresAuth() { return true; }

}
