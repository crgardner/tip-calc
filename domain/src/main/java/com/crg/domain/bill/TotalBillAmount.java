package com.crg.domain.bill;

import org.joda.money.Money;

public class TotalBillAmount {

    private final Money totalAmount;
    private final Money tipAmount;

    public TotalBillAmount(Money tipAmount, Money totalAmount) {
        this.tipAmount = tipAmount;
        this.totalAmount = totalAmount;
    }

    public Money tipAmount() {
        return tipAmount;
    }
    
    public Money totalAmount() {
        return totalAmount;
    }
    
}
