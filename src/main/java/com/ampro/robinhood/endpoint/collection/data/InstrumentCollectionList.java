package com.ampro.robinhood.endpoint.collection.data;

import java.util.ArrayList;
import java.util.List;

import com.ampro.robinhood.endpoint.instrument.data.InstrumentElement;
import com.ampro.robinhood.endpoint.instrument.methods.GetInstrumentByUrl;
import com.ampro.robinhood.net.ApiMethod;
import com.ampro.robinhood.net.request.RequestManager;
import com.ampro.robinhood.throwables.RobinhoodApiException;

/**
 * The Class representing an InstrumentFundamentalListElement.
 * 
 * @author MainStringArgs
 */
public class InstrumentCollectionList {

	/**
	 * The list of instruments that the request returned. This cannot be marked
	 * transient because it is set by GSON.
	 */
	private String[] instruments;

	/**
	 * Instantiates a new instrument fundamental list element.
	 */
	public InstrumentCollectionList() {
		super();
	}

	/**
	 * Gets the instrument list.
	 *
	 * @return the instrument fundamental list
	 * @throws RobinhoodApiException
	 *             the robinhood api exception
	 */
	public List<InstrumentElement> getInstrumentElementList() throws RobinhoodApiException {

		if (instruments != null) {

			// Return the array as a list for ease-of-use
			final List<InstrumentElement> elementList = new ArrayList<InstrumentElement>();

			for (final String result : instruments) {
				final ApiMethod method = new GetInstrumentByUrl(result);
				InstrumentElement element = null;

				try {

					element = RequestManager.getInstance().makeApiRequest(method);

				} catch (RobinhoodApiException e) {
					e.printStackTrace();
				}

				elementList.add(element);
			}

			return elementList;

		} else {
			throw new RobinhoodApiException("Error retrieving the list of instruments.");
		}
	}

}