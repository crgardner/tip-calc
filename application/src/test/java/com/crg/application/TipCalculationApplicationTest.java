package com.crg.application;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.joda.money.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import boundary.tip.*;

@RunWith(MockitoJUnitRunner.class)
public class TipCalculationApplicationTest {
    private TipCalculationBoundary application;
    private TipCalculationRequest tipCalculationRequest;
    private Money expectedTipAmount;
    private Money expectedTotalAmount;

    @Mock
    private TipCalculationResponseBoundary responseBoundary;

    @Before
    public void setUp() {
        application = new TipCalculationApplication();
    }

    @Test
    public void coordinatesTipCalculationForBill() {
        tipCalculationRequest = new TipCalculationRequest(11.25, 15);

        application.handle(tipCalculationRequest, responseBoundary);

        expectedTipAmount = Money.of(CurrencyUnit.USD, 1.69);
        expectedTotalAmount = Money.of(CurrencyUnit.USD, 12.94);

        verify(responseBoundary).receive(refEq(new TipCalculationResponse(expectedTipAmount, expectedTotalAmount)));

    }

}
