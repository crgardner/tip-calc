package boundary.tip;

import org.joda.money.Money;

public class TipCalculationResponse {

    private final Money tipAmount;
    private final Money totalAmount;


    public TipCalculationResponse(Money tipAmount, Money totalAmount) {
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
