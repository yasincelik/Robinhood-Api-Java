package conrad.weiser.robinhood.api.endpoint.midlands;

import conrad.weiser.robinhood.api.ApiMethod;

/**
 * The Class reprsenting the midlands API endpoint.
 * 
 * @author MainStringArgs
 */
public class Midlands extends ApiMethod {

	/**
	 * Instantiates a new midlands.
	 */
	protected Midlands() {

		super("midlands");

		// //We do require a token for these methods.
		// this.requireToken();
	}

}