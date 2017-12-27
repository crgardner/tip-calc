package com.crg.application;

import static com.crg.domain.money.MoneyFactory.*;
import static com.crg.domain.tip.TipRate.*;

import com.crg.boundary.tip.*;
import com.crg.domain.bill.*;

public class TipCalculationApplication implements TipCalculationBoundary {

    @Override
    public void handle(TipCalculationRequest request, TipCalculationResponseBoundary responseBoundary) {
        TotalBillAmount totalBillAmount = calculateAmount(request);
        TipCalculationResponse response = prepareResponse(totalBillAmount);

        responseBoundary.receive(response);
    }

    private TotalBillAmount calculateAmount(TipCalculationRequest request) {
        Bill bill = new Bill(usdOf(request.billAmount()));

        return bill.calculateTotalWith(of(request.tipRate()));
    }

    private TipCalculationResponse prepareResponse(TotalBillAmount totalBillAmount) {
        return new TipCalculationResponse(totalBillAmount.tipAmount(), totalBillAmount.totalAmount());
    }

}
