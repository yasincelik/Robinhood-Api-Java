package com.ampro.robinhood.endpoint.instrument.methods;

import com.ampro.robinhood.endpoint.instrument.data.InstrumentElementList;

public class SearchInstrumentsByKeyword extends GetInstrument {
    SearchInstrumentsByKeyword(String keyword) {
        super();
        setUrlBase("https://api.robinhood.com/instruments/?query=" + keyword);
        setReturnType(InstrumentElementList.class);
    }
}
