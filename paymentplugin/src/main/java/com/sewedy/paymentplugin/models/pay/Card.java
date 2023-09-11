package com.sewedy.paymentplugin.models.pay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Card {
    @Expose
    @SerializedName("expiry")
    private Expiry expiry;
    @Expose
    @SerializedName("securityCode")
    private String securityCode;
    @Expose
    @SerializedName("number")
    private String number;

    public Card(Expiry expiry, String securityCode, String number) {
        this.expiry = expiry;
        this.securityCode = securityCode;
        this.number = number;
    }

    public Expiry getExpiry() {
        return expiry;
    }

    public void setExpiry(Expiry expiry) {
        this.expiry = expiry;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
