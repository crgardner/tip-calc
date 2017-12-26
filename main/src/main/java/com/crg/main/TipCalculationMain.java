package com.crg.main;


import com.crg.api.hello.HelloWorld;
import com.crg.api.tip.RestTipCalculationResponsePresenter;
import com.crg.api.tip.TipController;
import com.crg.application.TipCalculationApplication;

import static spark.Spark.get;


public class TipCalculationMain {
    public static void main(String[] args) {

        TipController controller = new TipController(new TipCalculationApplication(), new RestTipCalculationResponsePresenter());

        HelloWorld helloWorld = new HelloWorld();
        
        get("/hello", helloWorld::say);
        get("/tip", controller::handle);
    }
}
