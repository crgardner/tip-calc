package com.crg.domain.bill;


import org.joda.money.Money;

import com.crg.domain.tip.TipRate;

public class Bill {

    private final Money billAmount;

    public Bill(Money billAmount) {
        this.billAmount = billAmount;
    }

    public TotalBillAmount calculateTotal(TipRate tipRate) {
        Money tipAmount = tipRate.multiply(billAmount);
        Money totalAmount = tipAmount.plus(billAmount);
        
        return new TotalBillAmount(tipAmount, totalAmount);
    }

}
