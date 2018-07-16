package com.ampro.robinhood.net.pagination;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.ApiElement;
import com.ampro.robinhood.endpoint.ApiElementList;

public class GetNextPage extends Paginate {

    public <E extends ApiElement> GetNextPage(ApiElementList<E> elementList, Configuration config) {
        super(elementList.getClass(), config);
        setUrlBase(elementList.getNext());
    }

    public <E extends ApiElement> GetNextPage(ApiElementList<E> elementList) {
        super(elementList.getClass());
        setUrlBase(elementList.getNext());
    }
}
