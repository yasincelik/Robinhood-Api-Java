package com.ampro.robinhood.endpoint.orders.data;

import java.io.Serializable;
import java.util.List;

import com.ampro.robinhood.endpoint.ApiElement;
import com.ampro.robinhood.endpoint.ApiElementList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * A paginated list of {@link SecurityOrderElement Order elements}.
 * @author Jonathan Augustine
 */
public class SecurityOrderElementList extends ApiElementList<SecurityOrderElement> {
    @Override
    public boolean requiresAuth() { return true; }
}
