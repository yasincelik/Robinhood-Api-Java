package com.ampro.robinhood.endpoint;

import com.ampro.robinhood.RobinhoodApi;
import com.ampro.robinhood.endpoint.quote.data.TickerQuoteElement;
import com.ampro.robinhood.endpoint.quote.data.TickerQuoteElementList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mashape.unirest.http.Unirest;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * A class that uses Robinhood pagination to iterate through an "incomplete"
 * list. <br>
 *     Since the Robinhood API returns Paginated lists of results when responses
 *     are too large, some responses will not contain all the requested data and
 *     will be difficult to work with from this codebase.
 *     <br>
 *     This class uses the "next" and "previous" URL strings provided from the
 *     Robinhood API response to Automatically request the next set of results.
 *     <br><br><em>
 *     Since a {@link PaginatedIterable} has to make calls to the API in order
 *     to iterate, it will be both reliant on an internet connection, as well
 *     as much slower than a normal {@link Iterable}</em><br><br>
 *
 * @author Jonathan Augustine
 * @param <T> The Element
 *           (e.g. a {@link TickerQuoteElementList} will have a type of
 *           {@link TickerQuoteElement})
 */
public class PaginatedIterable<T> implements Iterable<T> {

    private String token;

    @SerializedName("previous")
    @Expose
    protected String previous;

    @SerializedName("next")
    @Expose
    protected String next;

    /** An iterator for this class */
    private class PaginatedIterator implements Iterator<T> {
        @Override
        public boolean hasNext() {
            return PaginatedIterable.this.next != null;
        }

        @Override
        public T next() {
            Unirest.get(next);
            return null;
        }
    }

    /**
     * TODO
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new PaginatedIterator();
    }

    /**
     * TODO
     * @param consumer
     */
    @Override
    public void forEach(Consumer<? super T> consumer) {

    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

}
