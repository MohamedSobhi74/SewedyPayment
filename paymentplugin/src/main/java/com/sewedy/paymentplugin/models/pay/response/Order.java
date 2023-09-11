package com.sewedy.paymentplugin.models.pay.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {
    @Expose
    @SerializedName("totalRefundedAmount")
    private int totalRefundedAmount;
    @Expose
    @SerializedName("totalDisbursedAmount")
    private int totalDisbursedAmount;
    @Expose
    @SerializedName("totalCapturedAmount")
    private int totalCapturedAmount;
    @Expose
    @SerializedName("totalAuthorizedAmount")
    private int totalAuthorizedAmount;
    @Expose
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("merchantCurrency")
    private String merchantCurrency;
    @Expose
    @SerializedName("merchantCategoryCode")
    private String merchantCategoryCode;
    @Expose
    @SerializedName("merchantAmount")
    private int merchantAmount;
    @Expose
    @SerializedName("lastUpdatedTime")
    private String lastUpdatedTime;
    @Expose
    @SerializedName("id")
    private String id;
    @Expose
    @SerializedName("currency")
    private String currency;
    @Expose
    @SerializedName("creationTime")
    private String creationTime;
    @Expose
    @SerializedName("chargeback")
    private Chargeback chargeback;
    @Expose
    @SerializedName("authenticationStatus")
    private String authenticationStatus;
    @Expose
    @SerializedName("amount")
    private int amount;

    public int getTotalRefundedAmount() {
        return totalRefundedAmount;
    }

    public void setTotalRefundedAmount(int totalRefundedAmount) {
        this.totalRefundedAmount = totalRefundedAmount;
    }

    public int getTotalDisbursedAmount() {
        return totalDisbursedAmount;
    }

    public void setTotalDisbursedAmount(int totalDisbursedAmount) {
        this.totalDisbursedAmount = totalDisbursedAmount;
    }

    public int getTotalCapturedAmount() {
        return totalCapturedAmount;
    }

    public void setTotalCapturedAmount(int totalCapturedAmount) {
        this.totalCapturedAmount = totalCapturedAmount;
    }

    public int getTotalAuthorizedAmount() {
        return totalAuthorizedAmount;
    }

    public void setTotalAuthorizedAmount(int totalAuthorizedAmount) {
        this.totalAuthorizedAmount = totalAuthorizedAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMerchantCurrency() {
        return merchantCurrency;
    }

    public void setMerchantCurrency(String merchantCurrency) {
        this.merchantCurrency = merchantCurrency;
    }

    public String getMerchantCategoryCode() {
        return merchantCategoryCode;
    }

    public void setMerchantCategoryCode(String merchantCategoryCode) {
        this.merchantCategoryCode = merchantCategoryCode;
    }

    public int getMerchantAmount() {
        return merchantAmount;
    }

    public void setMerchantAmount(int merchantAmount) {
        this.merchantAmount = merchantAmount;
    }

    public String getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Chargeback getChargeback() {
        return chargeback;
    }

    public void setChargeback(Chargeback chargeback) {
        this.chargeback = chargeback;
    }

    public String getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(String authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
