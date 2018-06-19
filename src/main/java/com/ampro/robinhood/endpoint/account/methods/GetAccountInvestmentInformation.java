package com.ampro.robinhood.endpoint.account.methods;


import com.ampro.robinhood.endpoint.account.Account;
import com.ampro.robinhood.endpoint.account.data.AccountHolderInvestmentElement;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.request.RequestMethod;

/**
 * Created by SirensBell on 5/23/2017.
 */
public class GetAccountInvestmentInformation extends Account {

    public GetAccountInvestmentInformation() {

        this.setUrlBase("https://api.robinhood.com/user/investment_profile");

        //Add the headers into the request
        this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "application/json"));

        //This method is to be ran as GET
        this.setMethod(RequestMethod.GET);

        //Declare what the response should look like
        this.setReturnType(AccountHolderInvestmentElement.class);

    }
}
