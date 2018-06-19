package com.ampro.robinhood.endpoint.account.methods;


import com.ampro.robinhood.endpoint.account.Account;
import com.ampro.robinhood.endpoint.account.data.BasicUserInfoElement;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.request.RequestMethod;

public class GetBasicUserInfo extends Account {

    public GetBasicUserInfo() {

        this.setUrlBase("https://api.robinhood.com/user/");

        //Add the headers into the request
        this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "application/json"));

        //This method is ran as GET
        this.setMethod(RequestMethod.GET);

        //Declare what the response should look like
        this.setReturnType(BasicUserInfoElement.class);


    }

}
