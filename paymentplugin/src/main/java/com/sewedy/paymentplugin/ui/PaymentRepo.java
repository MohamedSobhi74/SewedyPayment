package com.sewedy.paymentplugin.ui;

import com.sewedy.paymentplugin.models.pay.request.PayRequest;
import com.sewedy.paymentplugin.models.pay.response.PayResponse;
import com.sewedy.paymentplugin.network.ApiInterface;
import com.sewedy.paymentplugin.network.RetrofitClient;

import io.reactivex.Observable;

public class PaymentRepo {

    ApiInterface apiInterface;

    public PaymentRepo() {
        apiInterface = RetrofitClient.getClient().create(ApiInterface.class);
    }

    public Observable<PayResponse> pay(String merchantId, String orderId, String transactionId, PayRequest payRequest){

        return apiInterface.pay(merchantId,orderId,transactionId,payRequest);
    }

}
