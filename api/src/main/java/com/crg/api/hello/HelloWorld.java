package com.crg.api.hello;

import spark.*;

public class HelloWorld {

    public String say(Request request, Response response) {
        response.status(200);
        return "hello, worldsss";
    }

}
