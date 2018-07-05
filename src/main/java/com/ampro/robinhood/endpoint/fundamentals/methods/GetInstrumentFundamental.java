package com.ampro.robinhood.endpoint.fundamentals.methods;

import com.ampro.robinhood.RobinhoodApi;
import com.ampro.robinhood.endpoint.fundamentals.data.InstrumentFundamentalElement;
import com.ampro.robinhood.net.request.RequestMethod;

/**
 * Given a instrument ID, this method returns a {@link InstrumentFundamentalElement}
 * for the given instrument.
 * This class is not implemented in {@link RobinhoodApi}
 * because these IDs are generally not public, and
 * must be retrieved from other API methods.
 */
public class GetInstrumentFundamental extends GetFundamental {

    public GetInstrumentFundamental(String instrumentUrl) {
        this.setUrlBase(instrumentUrl);

        //This method is run as GET
        this.setMethod(RequestMethod.GET);

        //Declare what the response should look like
        this.setReturnType(InstrumentFundamentalElement.class);

    }
}
