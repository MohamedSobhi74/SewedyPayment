package com.sewedy.paymentplugin.ui;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.sewedy.paymentplugin.models.pay.error.ErrorResponse;
import com.sewedy.paymentplugin.models.pay.request.PayRequest;
import com.sewedy.paymentplugin.models.pay.response.PayResponse;

import java.io.IOException;
import java.util.Objects;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PaymentUseCases {

    PaymentRepo paymentRepo;
    MutableLiveData<PayResponse> payResponseMutableLiveData;
    MutableLiveData<ErrorResponse> errorResponseMutableLiveData;


    public PaymentUseCases(MutableLiveData<PayResponse> payResponseMutableLiveData, MutableLiveData<ErrorResponse> errorResponseMutableLiveData) {
        paymentRepo = new PaymentRepo();
        this.payResponseMutableLiveData = payResponseMutableLiveData;
        this.errorResponseMutableLiveData = errorResponseMutableLiveData;
    }

    public void pay(String merchantId, String orderId, String transactionId, PayRequest payRequest) {

        paymentRepo.pay(merchantId, orderId, transactionId, payRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PayResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PayResponse loginResponse) {
                        payResponseMutableLiveData.postValue(loginResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("register erorr", e.getMessage());
                        if (e instanceof HttpException) {
                            HttpException httpException = (HttpException) e;
                            if (httpException.code() >= 400) {
                                Gson gson = new GsonBuilder().create();
                                ErrorResponse mError;
                                try {
                                    mError = gson.fromJson(Objects.requireNonNull(Objects.requireNonNull(httpException.response()).errorBody()).string(), ErrorResponse.class);
                                    errorResponseMutableLiveData.postValue(mError);
                                    //   Toast.makeText(context, mError.getDescription(), Toast.LENGTH_LONG).show();
                                } catch (IOException ioE) {
                                    // handle failure to read error
                                }
                            }
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
