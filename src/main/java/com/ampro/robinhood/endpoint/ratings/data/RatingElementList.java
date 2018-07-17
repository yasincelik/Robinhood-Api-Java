package com.ampro.robinhood.endpoint.ratings.data;

import com.ampro.robinhood.endpoint.ApiElementList;

/**
 * The Class RatingElementList.
 * 
 * @author MainStringArgs
 */
public class RatingElementList extends ApiElementList<RatingElement> {

  @Override
  public boolean requiresAuth() {
    return false;
  }

  @Override
  public String toString() {
    return "RatingElementList [results=" + results + "]";
  }


}
