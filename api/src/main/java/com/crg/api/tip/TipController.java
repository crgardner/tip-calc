package com.crg.api.tip;

import com.crg.boundary.tip.TipCalculationBoundary;
import com.crg.boundary.tip.TipCalculationRequest;
import com.crg.boundary.tip.TipCalculationResponseBoundary;

import spark.Request;
import spark.Response;

import java.math.BigDecimal;

public class TipController {
    private final TipCalculationBoundary tipCalculationBoundary;
    private final TipCalculationPresenter tipCalculationPresenter;

    public TipController(TipCalculationBoundary tipCalculationBoundary, TipCalculationPresenter tipCalculationPresenter) {
        this.tipCalculationBoundary = tipCalculationBoundary;
        this.tipCalculationPresenter = tipCalculationPresenter;
    }

    public BigDecimal handle(Request request, Response response) {
        TipCalculationViewModel tipCalculationViewModel = new TipCalculationViewModel();

        tipCalculationBoundary.handle(createRequest(), prepareResponse(tipCalculationViewModel));

        response.status(200);
        return tipCalculationViewModel.totalAmount();
    }

    private TipCalculationResponseBoundary prepareResponse(TipCalculationViewModel tipCalculationViewModel) {
        return tipCalculationResponse -> tipCalculationPresenter.present(tipCalculationViewModel, tipCalculationResponse);
    }

    private TipCalculationRequest createRequest() {
        return new TipCalculationRequest(12d, 20);
    }
}
