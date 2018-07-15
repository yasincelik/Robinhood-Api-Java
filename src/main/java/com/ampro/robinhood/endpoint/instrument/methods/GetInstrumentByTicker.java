package com.ampro.robinhood.endpoint.instrument.methods;

import com.ampro.robinhood.endpoint.instrument.data.InstrumentElementList;

/**
 * This returns a
 * {@link com.ampro.robinhood.endpoint.instrument.data.InstrumentElementList}
 * ... IDK why but it does, ask Robinhood idk
 * @author Jonathan Augustine
 */
public class GetInstrumentByTicker extends GetInstrument {
    public GetInstrumentByTicker(String ticker) {
        super();
        setUrlBase("https://api.robinhood.com/instruments/");
        addQueryParameter("symbol", ticker);
        //Declare what the response should look like
        this.setReturnType(InstrumentElementList.class);
    }
}
