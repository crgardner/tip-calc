package com.crg.api.tip;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import com.crg.boundary.tip.TipCalculationBoundary;
import com.crg.boundary.tip.TipCalculationRequest;
import com.crg.boundary.tip.TipCalculationResponse;
import com.crg.boundary.tip.TipCalculationResponseBoundary;
import com.crg.test.mockito.MockitoExtension;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;
import spark.Request;
import spark.Response;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class TipControllerTest implements TipCalculationResponseBoundary {
    @Mock
    private TipCalculationBoundary tipCalculationBoundary;

    @Mock
    private TipCalculationPresenter tipCalculationPresenter;

    @Mock
    private Request request;

    @Mock
    private Response response;

    @Mock
    private TipCalculationViewModel tipCalculationViewModel;

    private TipController tipController;
    private TipCalculationRequest tipCalculationRequest;
    private TipCalculationResponse tipCalculationResponse;

    public TipControllerTest() {
    }

    @BeforeEach
    public void init() {
        tipController = new TipController(tipCalculationBoundary, tipCalculationPresenter);
        tipCalculationRequest = new TipCalculationRequest(12d, 10);
        tipCalculationResponse = new TipCalculationResponse(Money.of(CurrencyUnit.USD, 12d),
                                                            Money.of(CurrencyUnit.USD, 20d));
    }

    @Test
    public void controlsAccessToTipBoundary() {
        doAnswer(byCallingOutputBoundary()).when(tipCalculationBoundary).handle(any(TipCalculationRequest.class), any(TipCalculationResponseBoundary.class));
        doAnswer(byPopulatingView()).when(tipCalculationPresenter).present(any(TipCalculationViewModel.class), eq(tipCalculationResponse));

        BigDecimal totalAmount = tipController.handle(request, response);

        verify(response).status(200);
        verify(tipCalculationPresenter).present(any(TipCalculationViewModel.class), eq(tipCalculationResponse));
        assertThat(totalAmount).isEqualTo(tipCalculationResponse.totalAmount().getAmount());
    }


    private Answer<TipCalculationBoundary> byCallingOutputBoundary() {
        return invocation -> {
            TipCalculationResponseBoundary responseBoundary = invocation.getArgument(1);
            responseBoundary.receive(tipCalculationResponse);

            return null;
        };
    }

    private Answer<TipCalculationPresenter> byPopulatingView() {
        return invocation -> {
            TipCalculationViewModel viewModel = invocation.getArgument(0);
            viewModel.totalAmount(tipCalculationResponse.totalAmount().getAmount());
            return null;
        };
    }

    @Override
    public void receive(TipCalculationResponse tipCalculationResponse) {

    }
}
