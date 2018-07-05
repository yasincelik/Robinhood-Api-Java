package com.ampro.robinhood.endpoint.instrument.data;

import com.ampro.robinhood.endpoint.PaginatedIterable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *
 * @author Jonathan Augustine
 */
public class InstrumentElementList extends PaginatedIterable<InstrumentElement> {

    @SerializedName("results")
    @Expose
    private List<InstrumentElement> results = null;

    public List<InstrumentElement> getResults() {
        return results;
    }

    public boolean isEmpty() { return this.results.isEmpty(); }
}
