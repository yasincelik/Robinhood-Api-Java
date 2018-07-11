package com.ampro.robinhood.endpoint.account.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.account.data.PositionElementList;
import com.ampro.robinhood.net.request.RequestMethod;
import com.ampro.robinhood.throwables.RobinhoodNotLoggedInException;

/**
 * Created by SirensBell on 6/19/2017.
 */
public class GetAccountPositions extends Account {

    public GetAccountPositions(Configuration config)
    throws RobinhoodNotLoggedInException {
        super(config);

        //Get the current account ID to be used with the position search
        String accountId = config.getAccountNumber();

        this.setUrlBase("https://api.robinhood.com/accounts/"
                + accountId + "/positions/");

        //This method is to be ran as GETe
        this.setMethodType(RequestMethod.GET);

        //Declare what the response should look like
        this.setReturnType(PositionElementList.class);

    }
}
