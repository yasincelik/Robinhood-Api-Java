package com.ampro.robinhood.endpoint.instrument.methods;

import com.ampro.robinhood.ApiMethod;
import com.ampro.robinhood.request.RequestMethod;

/**
 * An HTTP(S) wrapper object for making Instrument Get requests to the
 * Robinhood api.
 * @author Jonathan Augustine
 */
public abstract class GetInstrument extends ApiMethod {

    protected GetInstrument() {
        super("instrument");
        this.addHttpHeaderParameter("Accept", "application/json");
        this.setMethod(RequestMethod.GET);
    }
}
