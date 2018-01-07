package com.crg.main;


import com.crg.api.hello.HelloWorld;
import com.crg.api.tip.RestTipCalculationResponsePresenter;
import com.crg.api.tip.TipController;
import com.crg.application.TipCalculationApplicationFactory;
import com.crg.boundary.tip.TipCalculationBoundary;

import static spark.Spark.get;


public class TipCalculationMain {
    public static void main(String[] args) {
        TipCalculationBoundary tipCalculationBoundary = createTipCalculationBoundary();
        TipController controller = createTipController(tipCalculationBoundary);

        HelloWorld helloWorld = new HelloWorld();
        
        get("/hello", helloWorld::say);
        get("/tip", controller::handle);
    }

    private static TipController createTipController(TipCalculationBoundary tipCalculationBoundary) {
        return new TipController(tipCalculationBoundary, new RestTipCalculationResponsePresenter());
    }

    private static TipCalculationBoundary createTipCalculationBoundary() {
        TipCalculationApplicationFactory tipCalculationApplicationFactory = new TipCalculationApplicationFactory();
        return tipCalculationApplicationFactory.create();
    }

}
