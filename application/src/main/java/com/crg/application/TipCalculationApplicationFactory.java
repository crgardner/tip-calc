package com.crg.application;

import com.crg.boundary.tip.TipCalculationBoundary;

public class TipCalculationApplicationFactory {
    public TipCalculationBoundary create() {
        return new TipCalculationApplication();
    }
}
