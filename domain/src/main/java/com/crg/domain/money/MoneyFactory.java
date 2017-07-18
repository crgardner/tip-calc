package com.crg.domain.money;

import org.joda.money.*;

public final class MoneyFactory {
    private MoneyFactory() {}
    
    public static Money usdOf(double amount) {
        return Money.of(CurrencyUnit.USD, amount);
    }

}
