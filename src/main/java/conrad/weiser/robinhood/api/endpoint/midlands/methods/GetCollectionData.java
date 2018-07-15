package conrad.weiser.robinhood.api.endpoint.midlands.methods;

import conrad.weiser.robinhood.api.endpoint.midlands.Midlands;
import conrad.weiser.robinhood.api.endpoint.midlands.data.InstrumentFundamentalListElement;
import conrad.weiser.robinhood.api.parameters.HttpHeaderParameter;
import conrad.weiser.robinhood.api.request.RequestMethod;

/**
 * The Class GetCollectionData that allows querying for stocks based on
 * collection name.
 * 
 * @author MainStringArgs
 */
public class GetCollectionData extends Midlands {

	/**
	 * Instantiates the GetCollectionData class
	 * 
	 * Examples of collections include 'manufacturing', 'consumer-product', &
	 * '100-most-popular'
	 *
	 * @param collectionName
	 *            the collection name to query for.
	 */
	public GetCollectionData(final String collectionName) {
		super();
		
		this.setUrlBase("https://api.robinhood.com/midlands/tags/tag/" + collectionName + "/");

		// Add the headers into the request
		this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "application/json"));

		// This method is ran as GET
		this.setMethod(RequestMethod.GET);

		// Declare what the response should look like
		this.setReturnType(InstrumentFundamentalListElement.class);
	}
}
