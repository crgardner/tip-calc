package com.crg.api.tip;

import com.crg.boundary.tip.TipCalculationResponse;

public class RestTipCalculationResponsePresenter implements TipCalculationPresenter {
    @Override
    public void present(TipCalculationViewModel tipCalculationViewModel, TipCalculationResponse tipCalculationResponse) {
        tipCalculationViewModel.totalAmount(tipCalculationResponse.totalAmount().getAmount());
    }
}
