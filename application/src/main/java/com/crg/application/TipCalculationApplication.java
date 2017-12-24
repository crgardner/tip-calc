package com.crg.application;

import static com.crg.domain.money.MoneyFactory.*;
import static com.crg.domain.tip.TipRate.*;

import com.crg.boundary.tip.*;
import com.crg.domain.bill.*;

public class TipCalculationApplication implements TipCalculationBoundary {

    @Override
    public void handle(TipCalculationRequest request, TipCalculationResponseBoundary responseBoundary) {
        Bill bill = new Bill(usdOf(request.billAmount()));
        
        TotalBillAmount totalBillAmount = bill.calculateTotalWith(of(request.tipRate()));
        
        TipCalculationResponse response = new TipCalculationResponse(totalBillAmount.tipAmount(), totalBillAmount.totalAmount());
        
        responseBoundary.receive(response);
        
    }

}
