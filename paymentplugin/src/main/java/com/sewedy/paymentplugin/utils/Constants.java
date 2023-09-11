package com.sewedy.paymentplugin.utils;

import android.util.Base64;

public class Constants {
    public static String username = "";
    public static String password = "";
    public static String paymentCurrency = "EGP";

    public static String getAuth() {
        String auth = "Basic " + Base64.encodeToString(("merchant."+username+":"+password).getBytes(), Base64.NO_WRAP);
        return auth;
    }
}
