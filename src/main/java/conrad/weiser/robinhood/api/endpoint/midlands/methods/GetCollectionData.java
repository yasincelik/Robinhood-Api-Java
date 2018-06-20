package conrad.weiser.robinhood.api.endpoint.midlands.methods;

import conrad.weiser.robinhood.api.endpoint.midlands.Midlands;
import conrad.weiser.robinhood.api.endpoint.midlands.data.InstrumentFundamentalListElement;
import conrad.weiser.robinhood.api.parameters.HttpHeaderParameter;
import conrad.weiser.robinhood.api.request.RequestMethod;

/**
 * The Class GetCollectionData.
 */
public class GetCollectionData extends Midlands {

  /**
   * Instantiates gets the collection data.
   *
   * @param collectionName the collection
   */
  public GetCollectionData(String collectionName) {

    this.setUrlBase("https://api.robinhood.com/midlands/tags/tag/" + collectionName + "/");

    // Add the headers into the request
    this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "application/json"));

    // This method is ran as GET
    this.setMethod(RequestMethod.GET);

    // Declare what the response should look like
    this.setReturnType(InstrumentFundamentalListElement.class);
  }
}
