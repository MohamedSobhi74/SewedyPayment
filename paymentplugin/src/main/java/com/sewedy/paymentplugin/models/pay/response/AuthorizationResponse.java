package com.sewedy.paymentplugin.models.pay.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthorizationResponse {
    @Expose
    @SerializedName("transactionIdentifier")
    private String transactionIdentifier;
    @Expose
    @SerializedName("stan")
    private String stan;
    @Expose
    @SerializedName("responseCode")
    private String responseCode;
    @Expose
    @SerializedName("processingCode")
    private String processingCode;
    @Expose
    @SerializedName("posEntryMode")
    private String posEntryMode;
    @Expose
    @SerializedName("posData")
    private String posData;
    @Expose
    @SerializedName("financialNetworkCode")
    private String financialNetworkCode;
    @Expose
    @SerializedName("commercialCardIndicator")
    private String commercialCardIndicator;
    @Expose
    @SerializedName("commercialCard")
    private String commercialCard;
    @Expose
    @SerializedName("cardSecurityCodeError")
    private String cardSecurityCodeError;

    public String getTransactionIdentifier() {
        return transactionIdentifier;
    }

    public void setTransactionIdentifier(String transactionIdentifier) {
        this.transactionIdentifier = transactionIdentifier;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getProcessingCode() {
        return processingCode;
    }

    public void setProcessingCode(String processingCode) {
        this.processingCode = processingCode;
    }

    public String getPosEntryMode() {
        return posEntryMode;
    }

    public void setPosEntryMode(String posEntryMode) {
        this.posEntryMode = posEntryMode;
    }

    public String getPosData() {
        return posData;
    }

    public void setPosData(String posData) {
        this.posData = posData;
    }

    public String getFinancialNetworkCode() {
        return financialNetworkCode;
    }

    public void setFinancialNetworkCode(String financialNetworkCode) {
        this.financialNetworkCode = financialNetworkCode;
    }

    public String getCommercialCardIndicator() {
        return commercialCardIndicator;
    }

    public void setCommercialCardIndicator(String commercialCardIndicator) {
        this.commercialCardIndicator = commercialCardIndicator;
    }

    public String getCommercialCard() {
        return commercialCard;
    }

    public void setCommercialCard(String commercialCard) {
        this.commercialCard = commercialCard;
    }

    public String getCardSecurityCodeError() {
        return cardSecurityCodeError;
    }

    public void setCardSecurityCodeError(String cardSecurityCodeError) {
        this.cardSecurityCodeError = cardSecurityCodeError;
    }
}
