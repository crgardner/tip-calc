package boundary.tip;

import org.joda.money.Money;

public class TipCalculationResponse {

    private final Money tipAmount;
    private final Money totalAmount;


    public TipCalculationResponse(Money expectedTipAmount, Money expectedTotalAmount) {
        this.tipAmount = expectedTipAmount;
        this.totalAmount = expectedTotalAmount;
    }

    public Money tipAmount() {
        return tipAmount;
    }

    public Money totalAmount() {
        return totalAmount;
    }

}
