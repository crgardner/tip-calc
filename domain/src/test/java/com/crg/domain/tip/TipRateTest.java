package com.crg.domain.tip;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TipRateTest {
    private TipRate tipRate;

    @Test
    public void createsTipRateFromWholeTipRateAmount() throws Exception {
        tipRate = TipRate.of(20);
        
        assertThat(tipRate).isEqualToComparingFieldByField(new TipRate(0.2));
        
    }
}
