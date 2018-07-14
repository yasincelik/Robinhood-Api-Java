package com.ampro.robinhood.net.pagination;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.ApiElementList;
import com.ampro.robinhood.throwables.RobinhoodNotLoggedInException;

public class GetNextPage extends Paginate {

    public GetNextPage(ApiElementList elementList, Configuration config)
    throws RobinhoodNotLoggedInException {
        super(elementList.getClass(), config);
        setUrlBase(elementList.getNext());
    }

    public GetNextPage(ApiElementList elementList) {
        super(elementList.getClass());
        setUrlBase(elementList.getNext());
    }
}
