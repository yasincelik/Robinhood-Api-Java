package com.ampro.robinhood.endpoint.ratings.data;

import com.ampro.robinhood.endpoint.ApiElement;

/**
 * The Class RatingResult.
 * 
 * @author MainStringArgs
 */
public class RatingElement implements ApiElement {

  /** The summary. */
  private RatingSummary summary;

  /** The instrument id. */
  private String instrument_id;

  /**
   * Gets the summary.
   *
   * @return the summary
   */
  public RatingSummary getSummary() {
    return summary;
  }

  /**
   * Gets the instrument id.
   *
   * @return the instrument id
   */
  public String getInstrumentId() {
    return instrument_id;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "RatingResult [summary=" + summary + ", instrument_id=" + instrument_id + "]";
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.ampro.robinhood.endpoint.ApiElement#requiresAuth()
   */
  @Override
  public boolean requiresAuth() {
    return false;
  }

}
