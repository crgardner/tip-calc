package com.crg.boundary.tip;

public interface TipCalculationBoundary {

    void handle(TipCalculationRequest request, TipCalculationResponseBoundary responseBoundary);

}
