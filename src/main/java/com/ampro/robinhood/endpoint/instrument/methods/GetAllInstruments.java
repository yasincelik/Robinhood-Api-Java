package com.ampro.robinhood.endpoint.instrument.methods;

import com.ampro.robinhood.endpoint.instrument.data.InstrumentElementList;

/**
 * TODO
 * Get all instruments listed by the Robinhood API
 * @author Jonathan Augustine
 */
public class GetAllInstruments extends GetInstrument{

    GetAllInstruments() {
        super();
        this.setReturnType(InstrumentElementList.class);
    }

}
