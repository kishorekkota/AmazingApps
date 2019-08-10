package com.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaHandler implements RequestHandler<String, String> {


    @Override
    public String handleRequest(String input, Context context) {


        context.getLogger().log("WHat theee ?"+ input);

        return "Helllo";
    }
}
