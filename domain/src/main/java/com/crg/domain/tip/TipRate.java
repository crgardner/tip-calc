package com.crg.domain.tip;

import java.math.RoundingMode;

import org.joda.money.Money;

public class TipRate {

    private final double tipRateValue;

    TipRate(double tipRateValue) {
        this.tipRateValue = tipRateValue;
    }

    public static TipRate of(int wholeTipRate) {
        return new TipRate(wholeTipRate / 100.0);
    }

    public Money multiply(Money amount) {
        return amount.multipliedBy(tipRateValue, RoundingMode.UP);
    }

}
