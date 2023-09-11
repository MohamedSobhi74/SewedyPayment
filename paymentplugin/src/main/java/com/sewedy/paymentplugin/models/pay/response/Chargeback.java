package com.sewedy.paymentplugin.models.pay.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chargeback {
    @Expose
    @SerializedName("currency")
    private String currency;
    @Expose
    @SerializedName("amount")
    private int amount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
