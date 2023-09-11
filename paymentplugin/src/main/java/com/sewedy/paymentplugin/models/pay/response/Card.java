package com.sewedy.paymentplugin.models.pay.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sewedy.paymentplugin.models.pay.Expiry;

public class Card {
    @Expose
    @SerializedName("storedOnFile")
    private String storedOnFile;
    @Expose
    @SerializedName("scheme")
    private String scheme;
    @Expose
    @SerializedName("number")
    private String number;
    @Expose
    @SerializedName("fundingMethod")
    private String fundingMethod;
    @Expose
    @SerializedName("expiry")
    private Expiry expiry;
    @Expose
    @SerializedName("brand")
    private String brand;

    public String getStoredOnFile() {
        return storedOnFile;
    }

    public void setStoredOnFile(String storedOnFile) {
        this.storedOnFile = storedOnFile;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFundingMethod() {
        return fundingMethod;
    }

    public void setFundingMethod(String fundingMethod) {
        this.fundingMethod = fundingMethod;
    }

    public Expiry getExpiry() {
        return expiry;
    }

    public void setExpiry(Expiry expiry) {
        this.expiry = expiry;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
