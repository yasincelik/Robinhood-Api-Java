package com.ampro.robinhood.net.pagination;

import com.ampro.robinhood.RobinhoodApi;
import com.ampro.robinhood.endpoint.ApiElement;
import com.ampro.robinhood.endpoint.quote.data.TickerQuoteElement;
import com.ampro.robinhood.endpoint.quote.data.TickerQuoteElementList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * TODO WARN!! THIS interface IS NOT FINISHED, DO NOT USE IT!!
 * A interface that uses Robinhood pagination to iterate through an "incomplete"
 * list. <br>
 *     Since the Robinhood API returns Paginated lists of results when responses
 *     are too large, some responses will not contain all the requested data and
 *     will be difficult to work with from this codebase.
 *     <br>
 *     This interface uses the "next" and "previous" URL strings provided from the
 *     Robinhood API response to Automatically request the next set of results.
 *     <br><br><em>
 *     Since a {@link PaginatedIterable} has to make calls to the API in order
 *     to iterate, it will be both reliant on an internet connection, as well
 *     as much slower than a normal {@link Iterable}</em><br><br>
 *     <br>
 *         In order to allow for iteration over private elements (like Accounts)
 *         a {@link com.ampro.robinhood.Configuration} is needed. Since
 *         an {@link ApiElement} does not contain a config, making this a interface
 *         to be extended would add some complexity that it not needed. Therefore,
 *         a paginatedIterable will be build from within an API instance (so that
 *         the config can be taken from there). See
 *         {@link RobinhoodApi#//buildIterable}
 *
 * @author Jonathan Augustine
 * @param <T> The Element
 *           (e.g. a {@link TickerQuoteElementList} will have a type of
 *           {@link TickerQuoteElement})
 */
public interface PaginatedIterable<T extends ApiElement> extends Iterable<T> {

    /**
     * TODO WARN!! THIS interface IS NOT FINISHED, DO NOT USE IT!!
     * @return
     */
    @Override
    default Iterator<T> iterator() {
        return null;
    }

    /**
     * @param consumer
     */
    @Override
    default void forEach(Consumer<? super T> consumer) {
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            consumer.accept(iterator.next());
        }
    }

    String getNext();

    String getPrevious();

}
