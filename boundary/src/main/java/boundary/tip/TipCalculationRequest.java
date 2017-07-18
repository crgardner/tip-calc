package boundary.tip;

public class TipCalculationRequest {

    private final double billAmount;
    private final int tipRate;

    public TipCalculationRequest(double billAmount, int tipRate) {
        this.billAmount = billAmount;
        this.tipRate = tipRate;
    }

    public double billAmount() {
        return billAmount;
    }

    public int tipRate() {
        return tipRate;
    }

}
