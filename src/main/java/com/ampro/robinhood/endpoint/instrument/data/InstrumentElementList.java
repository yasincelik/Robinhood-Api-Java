package com.ampro.robinhood.endpoint.instrument.data;

import com.ampro.robinhood.endpoint.ApiElementList;

/**
 * A Paginated List of {@link InstrumentElement}
 * @author Jonathan Augustine
 */
public class InstrumentElementList extends ApiElementList<InstrumentElement> {

    /**
     * @return If the element requires an authorized API (i.e. Is user-specific data)
     */
    @Override
    public boolean requiresAuth() { return false; }
}
