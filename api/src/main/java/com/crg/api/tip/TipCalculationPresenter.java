package com.crg.api.tip;

import com.crg.boundary.tip.TipCalculationResponse;

public interface TipCalculationPresenter {
    void present(TipCalculationViewModel tipCalculationViewModel, TipCalculationResponse tipCalculationResponse);
}
