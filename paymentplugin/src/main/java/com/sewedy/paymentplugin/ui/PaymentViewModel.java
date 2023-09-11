package com.sewedy.paymentplugin.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sewedy.paymentplugin.models.pay.error.ErrorResponse;
import com.sewedy.paymentplugin.models.pay.request.PayRequest;
import com.sewedy.paymentplugin.models.pay.response.PayResponse;

public class PaymentViewModel extends ViewModel {

    MutableLiveData<PayResponse> payResponseMutableLiveData;
    MutableLiveData<ErrorResponse> errorResponseMutableLiveData;
    PaymentUseCases paymentUseCases;

    public PaymentViewModel() {
        payResponseMutableLiveData = new MutableLiveData<>();
        errorResponseMutableLiveData = new MutableLiveData<>();
        paymentUseCases = new PaymentUseCases(payResponseMutableLiveData, errorResponseMutableLiveData);
    }

    public void pay(String merchantId, String orderId, String transactionId, PayRequest payRequest) {
        paymentUseCases.pay(merchantId,orderId,transactionId, payRequest);
    }
}
