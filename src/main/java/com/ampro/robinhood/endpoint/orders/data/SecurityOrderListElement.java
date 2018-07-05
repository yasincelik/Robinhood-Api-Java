package com.ampro.robinhood.endpoint.orders.data;

import java.io.Serializable;
import java.util.List;

import com.ampro.robinhood.endpoint.ApiElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * A paginated list of {@link SecurityOrderElement Order elements}.
 * @author Jonathan Augustine
 */
public class SecurityOrderListElement implements Serializable, ApiElement {

    @SerializedName("previous")
    @Expose
    private String previous;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("results")
    @Expose
    private List<SecurityOrderElement> results;
    private final static long serialVersionUID = 8540422867484529896L;

    public Object getPrevious() {
        return previous;
    }

    public List<SecurityOrderElement> getSecurtiyOrders() {
        return results;
    }

    @Override
    public boolean requiresAuth() { return true; }

}
