package com.sewedy.paymentplugin.models.pay.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {
    @Expose
    @SerializedName("gatewayRecommendation")
    private String gatewayRecommendation;
    @Expose
    @SerializedName("gatewayCode")
    private String gatewayCode;
    @Expose
    @SerializedName("cardSecurityCode")
    private CardSecurityCode cardSecurityCode;
    @Expose
    @SerializedName("acquirerMessage")
    private String acquirerMessage;
    @Expose
    @SerializedName("acquirerCode")
    private String acquirerCode;

    public String getGatewayRecommendation() {
        return gatewayRecommendation;
    }

    public void setGatewayRecommendation(String gatewayRecommendation) {
        this.gatewayRecommendation = gatewayRecommendation;
    }

    public String getGatewayCode() {
        return gatewayCode;
    }

    public void setGatewayCode(String gatewayCode) {
        this.gatewayCode = gatewayCode;
    }

    public CardSecurityCode getCardSecurityCode() {
        return cardSecurityCode;
    }

    public void setCardSecurityCode(CardSecurityCode cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }

    public String getAcquirerMessage() {
        return acquirerMessage;
    }

    public void setAcquirerMessage(String acquirerMessage) {
        this.acquirerMessage = acquirerMessage;
    }

    public String getAcquirerCode() {
        return acquirerCode;
    }

    public void setAcquirerCode(String acquirerCode) {
        this.acquirerCode = acquirerCode;
    }
}
