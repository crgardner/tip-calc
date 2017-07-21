package com.crg.main;


import static spark.Spark.*;

import com.crg.api.hello.HelloWorld;


public class TipCalculationMain {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        
        get("/hello", helloWorld::say);
    }
}
