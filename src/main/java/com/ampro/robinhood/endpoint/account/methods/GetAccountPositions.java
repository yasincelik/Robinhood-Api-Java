package com.ampro.robinhood.endpoint.account.methods;


import com.ampro.robinhood.ConfigurationManager;
import com.ampro.robinhood.endpoint.account.Account;
import com.ampro.robinhood.endpoint.account.data.PositionListElement;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.request.RequestMethod;

/**
 * Created by SirensBell on 6/19/2017.
 */
public class GetAccountPositions extends Account {

    public GetAccountPositions() {

        //Get the current account ID to be used with the position search
        String accountId = ConfigurationManager.getInstance().getAccountNumber();

        this.setUrlBase("https://api.robinhood.com/accounts/" + accountId + "/positions/");

        //Add the headers into the request'
        this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "application/json"));

        //This method is to be ran as GETe
        this.setMethod(RequestMethod.GET);

        //Declare what the response should look like
        this.setReturnType(PositionListElement.class);

    }
}
