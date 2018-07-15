package conrad.weiser.robinhood.api.endpoint.midlands.data;

import java.util.ArrayList;
import java.util.List;
import conrad.weiser.robinhood.api.ApiMethod;
import conrad.weiser.robinhood.api.endpoint.fundamentals.data.InstrumentFundamentalElement;
import conrad.weiser.robinhood.api.endpoint.fundamentals.methods.GetInstrumentFundamental;
import conrad.weiser.robinhood.api.request.RequestManager;
import conrad.weiser.robinhood.api.throwables.RobinhoodApiException;

/**
 * The Class representing an InstrumentFundamentalListElement.
 * 
 * @author MainStringArgs
 */
public class InstrumentFundamentalListElement {

	/** The list of instruments that the request returned */
	private transient String[] instruments;

	/** The request manager. */
	private transient RequestManager requestManager;

	/**
	 * Instantiates a new instrument fundamental list element.
	 */
	public InstrumentFundamentalListElement() {
		super();

		requestManager = RequestManager.getInstance();
	}

	/**
	 * Gets the instrument fundamental list.
	 *
	 * @return the instrument fundamental list
	 * @throws RobinhoodApiException
	 *             the robinhood api exception
	 */
	public List<InstrumentFundamentalElement> getInstrumentFundamentalList() throws RobinhoodApiException {

		if (instruments != null) {

			// Return the array as a list for ease-of-use
			final List<InstrumentFundamentalElement> elementList = new ArrayList<InstrumentFundamentalElement>();

			for (final String result : instruments) {
				final ApiMethod method = new GetInstrumentFundamental(result);
				InstrumentFundamentalElement element = null;

				try {

					element = requestManager.makeApiRequest(method);

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
