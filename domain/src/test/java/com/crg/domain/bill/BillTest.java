package com.crg.domain.bill;

import static org.assertj.core.api.Assertions.*;

import org.joda.money.*;
import org.junit.jupiter.api.Test;

import com.crg.domain.tip.TipRate;

public class BillTest {
    private Bill bill;
    private TotalBillAmount totalBillAmount;

    @Test
    public void calculatesTotalAmountBasedOnTipRate() throws Exception {
        bill = new Bill(Money.of(CurrencyUnit.USD, 2d));

        totalBillAmount = bill.calculateTotalWith(TipRate.of(10));

        assertThat(totalBillAmount).isEqualToComparingFieldByField(
                new TotalBillAmount(Money.of(CurrencyUnit.USD, 0.2), Money.of(CurrencyUnit.USD, 2.2)));
    }
}
