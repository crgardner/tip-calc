package com.crg.domain.tip;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

@DisplayName("TipRate")
public class TipRateTest {
    private TipRate tipRate;

    @Test
    @DisplayName("creates a tip rate from a whole tip rate amount")
    public void createsTipRateFromWholeTipRateAmount() throws Exception {
        tipRate = TipRate.of(20);
        
        assertThat(tipRate).isEqualToComparingFieldByField(new TipRate(0.2));
    }
}
