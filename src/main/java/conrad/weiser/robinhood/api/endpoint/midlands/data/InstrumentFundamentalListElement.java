package conrad.weiser.robinhood.api.endpoint.midlands.data;

import java.util.ArrayList;
import java.util.List;
import conrad.weiser.robinhood.api.ApiMethod;
import conrad.weiser.robinhood.api.endpoint.fundamentals.data.InstrumentFundamentalElement;
import conrad.weiser.robinhood.api.endpoint.fundamentals.methods.GetInstrumentFundamental;
import conrad.weiser.robinhood.api.request.RequestManager;
import conrad.weiser.robinhood.api.throwables.RobinhoodApiException;

public class InstrumentFundamentalListElement {



  /**
   * The list of instruments that the user is currently in
   */
  private String[] instruments;


  public List<InstrumentFundamentalElement> getInstrumentFundamentalList()
      throws RobinhoodApiException {

    if (instruments != null) {

      // Return the array as a list for ease-of-use
      List<InstrumentFundamentalElement> elementList = new ArrayList();

      for (String result : instruments) {
        ApiMethod method = new GetInstrumentFundamental(result);
        InstrumentFundamentalElement element = null;

        try {

          element = RequestManager.getInstance().makeApiRequest(method);


        } catch (RobinhoodApiException e) {
          e.printStackTrace();
        }

        elementList.add(element);
      }

      return elementList;

    } else
      throw new RobinhoodApiException("Error retrieving the list of instruments.");
  }

}
