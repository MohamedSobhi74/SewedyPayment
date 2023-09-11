package com.sewedy.paymentplugin.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sewedy.paymentplugin.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public  static Retrofit retrofit = null;
    private static String lang;

    public static Retrofit getClient ()
    {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        client.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                        .addHeader("Accept","application/json")
                    .addHeader("Authorization", Constants.getAuth())
                        .build();
            return chain.proceed(request);
        });


        client.addInterceptor(httpLoggingInterceptor);
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl("https://banquemisr.gateway.mastercard.com/api/rest/version/68/")
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
