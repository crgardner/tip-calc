package com.crg.domain.bill;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.crg.domain.money.MoneyFactory;

@DisplayName("TotalBillAmount")
public class TotalBillAmountTest {
    private TotalBillAmount totalBillAmount;

    @Test
    @DisplayName("holds a total bill amount and tip amount")
    public void holdsTotalBillAmountAndTipAmount() throws Exception {
        totalBillAmount = new TotalBillAmount(MoneyFactory.usdOf(1.50),MoneyFactory.usdOf(45.50));
        
        assertThat(totalBillAmount.tipAmount()).isEqualTo(MoneyFactory.usdOf(1.50));
        assertThat(totalBillAmount.totalAmount()).isEqualTo(MoneyFactory.usdOf(45.50));
    }
}
