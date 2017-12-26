package com.crg.api.tip;

import java.math.BigDecimal;

public class TipCalculationViewModel {
    private BigDecimal totalTipAmount;

    public void totalAmount(BigDecimal totalTipAmount) {
        this.totalTipAmount = totalTipAmount;
    }

    public BigDecimal totalAmount() {
        return totalTipAmount;
    }
}
