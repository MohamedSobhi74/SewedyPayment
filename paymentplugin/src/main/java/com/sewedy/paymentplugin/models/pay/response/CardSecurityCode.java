package com.sewedy.paymentplugin.models.pay.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardSecurityCode {
    @Expose
    @SerializedName("gatewayCode")
    private String gatewayCode;
    @Expose
    @SerializedName("acquirerCode")
    private String acquirerCode;

    public String getGatewayCode() {
        return gatewayCode;
    }

    public void setGatewayCode(String gatewayCode) {
        this.gatewayCode = gatewayCode;
    }

    public String getAcquirerCode() {
        return acquirerCode;
    }

    public void setAcquirerCode(String acquirerCode) {
        this.acquirerCode = acquirerCode;
    }
}
