package com.ampro.robinhood;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ampro.robinhood.net.parameters.HttpHeaderParameter;
import com.ampro.robinhood.net.parameters.UrlParameter;
import com.ampro.robinhood.net.request.RequestMethod;
import com.ampro.robinhood.throwables.RobinhoodNotLoggedInException;

/**
 * A Wrapper object for making REST requests through
 * {@link com.mashape.unirest.http.Unirest}
 * @author Conrad Weisse, Modified by Jonathan Augustine
 */
public abstract class ApiMethod {

	protected final Configuration config;
	private String urlBase;
	public final String service;

	/**
	 * Constructor which stores the service which is being used
	 */
	protected ApiMethod(String service, Configuration config) {
	    this.config = config;
		this.service = service;
        //All methods get json responses
        this.addHttpHeaderParameter("Accept", "appliation/json");
	}

	/**
	 * Linked List containing all of the urlParameters for the next request
	 */
	private final List<UrlParameter> urlParameters = new LinkedList<>();

	/**
	 * Linked List containing all of the HttpHeaderParameters for the next request
	 */
	private final List<HttpHeaderParameter> httpHeaderParameters = new LinkedList<>();

	/** Default request method is GET*/
	private RequestMethod method = RequestMethod.GET;

	/** The body for the request */
	private String body = null;

	/** The return type for the request */
	private Type returnType = null;

	/**
	 * A flag for the method specifying if it requires an AuthToken for the
     * user in order to be ran.
	 */
	private boolean requireToken = false;

	/**
	 * A method which adds a HttpHeaderParameter to the API request header
	 * @param param The parameter which should be added into the ApiRequest
	 */
	protected void addHttpHeaderParameter(HttpHeaderParameter param) {
		httpHeaderParameters.add(param);
	}

    /**
     * A method which adds a HttpHeaderParameter to the API request header
     * @param key The key to map to
     * @param value The value to map
     * @author Jonathan Augustine
     */
	protected void addHttpHeaderParameter(String key, String value) {
	    httpHeaderParameters.add(new HttpHeaderParameter(key, value));
    }

    /**
     * A method which adds HttpHeaderParameters to the API request header
     * @param paramMap A String -> String map of Key -> Val pairs
     * @author Jonathan Augustine
     */
    protected void addHttpHeaderParameters(Map<String, String> paramMap) {
	    paramMap.forEach((key, val) -> addHttpHeaderParameter(key, val));
    }

    /**
     * A method which adds HttpHeaderParameters to the API request header
     * @param params A Collection of {@link HttpHeaderParameter}
     * @author Jonathan Augustine
     */
    protected void addHttpHeaderParameters(Collection<HttpHeaderParameter> params) {
        params.forEach((header) -> addHttpHeaderParameter(header));
    }

	/**
	 * A method which adds a HttpUrlParameter to the API URL
     * @param param The {@link UrlParameter} to add
	 */
	protected void addUrlParameter(UrlParameter param) {
		urlParameters.add(param);
	}

    /**
     * A method which adds a HttpUrlParameter to the API URL
     * @param key The key to map to
     * @param val The value to map
     * @author Jonathan Augustine
     */
	protected void addUrlParameter(String key, String val) {
	    urlParameters.add(new UrlParameter(key, val));
    }

    /**
     * A method which adds a HttpUrlParameter to the API URL
     * @param key The key to map to
     * @param val The value to map
     * @author Jonathan Augustine
     */
    protected void addUrlParameter(String key, int val) {
        urlParameters.add(new UrlParameter(key, val));
    }

    /**
     * A method which adds a HttpUrlParameter to the API URL
     * @param key The key to map to
     * @param val The value to map
     * @author Jonathan Augustine
     */
    protected void addUrlParameter(String key, long val) {
        urlParameters.add(new UrlParameter(key, val));
    }

    /**
     * A method which adds a HttpUrlParameter to the API URL
     * @param key The key to map to
     * @param val The value to map
     * @author Jonathan Augustine
     */
    protected void addUrlParameter(String key, boolean val) {
        urlParameters.add(new UrlParameter(key, val));
    }

    /**
     * A method which adds a HttpUrlParameter to the API URL
     * @param key The key to map to
     * @param val The value to map
     * @author Jonathan Augustine
     */
    protected void addUrlParameter(String key, Object val) {
        urlParameters.add(new UrlParameter(key, val));
    }


    /**
     * A method which adds HttpUrlParameters to the API URL
     * @param params The {@link UrlParameter UrlParameters} to add
     * @author Jonathan Augustine
     */
    protected void addUrlParameters(Collection<UrlParameter> params) {
	    params.forEach(p -> addUrlParameter(p));
    }

    /**
     * A method which adds HttpUrlParameters to the API URL
     * @param paramMap A String -> String map of Key -> Val pairs
     * @author Jonathan Augustine
     */
    protected void addUrlParameters(Map<String, String> paramMap) {
        paramMap.forEach((key, val) -> addUrlParameter(new UrlParameter(key, val)));
    }

	/**
	 * Method which adds the Authorization Token to the HTTP request header
	 * @throws RobinhoodNotLoggedInException if the token does not exist or
     *              If the user is not logged in.
	 */
	protected void addAuthTokenParameter() throws RobinhoodNotLoggedInException {
		addHttpHeaderParameter("Authorization", "Token " + this.config.getToken());
	}

	/**
	 * Method which returns if the User Token is required for this method or not
	 */
	public boolean requiresToken() {
		return this.requireToken;
	}

	/** Method which returns the request body */
	public String getBody() {
		return this.body;
	}

	/** Method to return what the ReturnType is */
	public Type getReturnType() {
		return this.returnType;
	}

	/**
	 * Method to retrieve all of the HttpHeaderParameters currently loaded into
     * the method
	 */
	public List<HttpHeaderParameter> getHttpHeaderParameters() {
		return this.httpHeaderParameters;
	}

	/**
	 * Method to return what the request method is for this method
	 */
	public RequestMethod getMethod() {
		return this.method;
	}

	/**
	 * Method which gets the loaded URL with all of the parameters included in
	 * the GET url parameters
	 * @throws MalformedURLException
	 */
	public URL getUrl() throws MalformedURLException {
		StringBuilder builder = new StringBuilder(urlBase);
		char connectorValue = '?';
		for (UrlParameter p : urlParameters) {
			builder.append(connectorValue).append(p.toString());
			connectorValue = '&';
		}
		return new URL(builder.toString());
	}

	/**
	 * Method which returns the base URL without any of the parameters
	 */
	public String getBaseUrl() {
		return this.urlBase;
	}

	/**
	 * Method which gets all of the URL parameters, without including them in the URL base
	 * This is useful for POST requests, which require these parameters to not be given as GET
	 * variables, but to be used in the POST value
	 */
	public String getUrlParametersAsPostBody() {
		StringBuilder builder = new StringBuilder();
		char connectorValue = '&';
		boolean first = true;
		for (UrlParameter p : urlParameters) {
			if(first){
				builder.append(p.toString());
				first = false;
			}
			else
				builder.append(connectorValue).append(p.toString());
		}

		return builder.toString();
	}

	/**
	 * Method to set the request to require an AuthToken
	 */
	protected void requireToken() {
		this.requireToken = true;
	}

	/**
	 * Method to set the request method
	 */
	protected void setMethod(RequestMethod method) {
		this.method = method;
	}

	/**
	 * Method to set what return type this method requires
	 */
	protected void setReturnType(Type returnType) {
		this.returnType = returnType;
	}

	/**
	 * Method which sets the URL base.
	 * For example, it will probably always be "api.robinhood.com/"
	 * This exists however for flexibility
	 */
	protected void setUrlBase(String urlBase) {
		this.urlBase = urlBase;
	}

	/**
	 * As this is an abstract method, this override gets the name of the implementing class
	 * @return The classes simplename
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

}
