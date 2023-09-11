package com.sewedy.paymentplugin.network;

import com.sewedy.paymentplugin.models.pay.request.PayRequest;
import com.sewedy.paymentplugin.models.pay.response.PayResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface ApiInterface {


    //auth
    //@FormUrlEncoded
    @PUT("merchant/{merchantId}/order/{orderId}/transaction/{transactionId}")
    Observable<PayResponse> pay(
            @Path("merchantId") String merchantId,
            @Path("orderId") String orderId,
            @Path("transactionId") String transactionId,
            @Body PayRequest payRequest);

}

