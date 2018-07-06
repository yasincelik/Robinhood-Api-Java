package com.ampro.robinhood.endpoint.account.methods;


import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.account.data.BasicUserInfoElement;
import com.ampro.robinhood.net.request.RequestMethod;

public class GetBasicUserInfo extends Account {

    public GetBasicUserInfo(Configuration config) {
        super(config);
        this.setUrlBase("https://api.robinhood.com/user/");

        //This method is ran as GET
        this.setMethodType(RequestMethod.GET);

        //Declare what the response should look like
        this.setReturnType(BasicUserInfoElement.class);

    }

}
