package com.ampro.robinhood.endpoint.instrument.methods;

import com.ampro.robinhood.endpoint.instrument.data.InstrumentElement;

/**
 * Get an {@link InstrumentElement} by a predefined URL
 * @author Jonathan Augustine
 */
public class GetInstrumentByUrl extends GetInstrument {
    public GetInstrumentByUrl(String url) {
        super();
        this.setUrlBase(url);
        this.setReturnType(InstrumentElement.class);
    }
}
