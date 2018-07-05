package com.ampro.robinhood.endpoint.instrument.methods;

import com.ampro.robinhood.endpoint.instrument.data.InstrumentElementList;

/**
 * @author Jonathan Augustine
 */
public class GetInstrumentByTicker extends GetInstrument {
    public GetInstrumentByTicker(String ticker) {
        super();
        setUrlBase("https://api.robinhood.com/instruments/?symbol=" + ticker);
        //Declare what the response should look like
        this.setReturnType(InstrumentElementList.class);

    }
}
