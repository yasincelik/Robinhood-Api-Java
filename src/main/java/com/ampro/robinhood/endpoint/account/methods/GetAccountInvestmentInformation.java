package com.ampro.robinhood.endpoint.account.methods;


import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.account.data.AccountHolderInvestmentElement;
import com.ampro.robinhood.net.request.RequestMethod;

/**
 * Created by SirensBell on 5/23/2017.
 */
public class GetAccountInvestmentInformation extends Account {

    public GetAccountInvestmentInformation(Configuration config) {
        super(config);

        this.setUrlBase("https://api.robinhood.com/user/investment_profile");

        //This method is to be ran as GET
        this.setMethod(RequestMethod.GET);

        //Declare what the response should look like
        this.setReturnType(AccountHolderInvestmentElement.class);

    }
}
