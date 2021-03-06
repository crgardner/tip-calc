package com.crg.application;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.joda.money.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import com.crg.boundary.tip.*;
import com.crg.test.mockito.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("TipCalculationApplication")
class TipCalculationApplicationTest {
    private TipCalculationBoundary application;
    private TipCalculationRequest tipCalculationRequest;
    private Money expectedTipAmount;
    private Money expectedTotalAmount;

    @Mock
    private TipCalculationResponseBoundary responseBoundary;

    @BeforeEach
    public void setUp() {
        application = new TipCalculationApplication();
    }

    @Test
    @DisplayName("coordinates tip calculation for a bill")
    void coordinatesTipCalculationForBill() {
        tipCalculationRequest = new TipCalculationRequest(11.25, 15);

        application.handle(tipCalculationRequest, responseBoundary);

        expectedTipAmount = Money.of(CurrencyUnit.USD, 1.69);
        expectedTotalAmount = Money.of(CurrencyUnit.USD, 12.94);

        verify(responseBoundary).receive(refEq(new TipCalculationResponse(expectedTipAmount, expectedTotalAmount)));

    }

}
