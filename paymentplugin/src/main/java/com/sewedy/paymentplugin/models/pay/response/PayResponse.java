package com.sewedy.paymentplugin.models.pay.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sewedy.paymentplugin.models.pay.SourceOfFunds;

public class PayResponse {

    @Expose
    @SerializedName("version")
    private String version;
    @Expose
    @SerializedName("transaction")
    private Transaction transaction;
    @Expose
    @SerializedName("timeOfRecord")
    private String timeOfRecord;
    @Expose
    @SerializedName("timeOfLastUpdate")
    private String timeOfLastUpdate;
    @Expose
    @SerializedName("sourceOfFunds")
    private SourceOfFunds sourceOfFunds;
    @Expose
    @SerializedName("result")
    private String result;
    @Expose
    @SerializedName("response")
    private Response response;
    @Expose
    @SerializedName("order")
    private Order order;
    @Expose
    @SerializedName("merchant")
    private String merchant;
    @Expose
    @SerializedName("gatewayEntryPoint")
    private String gatewayEntryPoint;
    @Expose
    @SerializedName("authorizationResponse")
    private AuthorizationResponse authorizationResponse;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getTimeOfRecord() {
        return timeOfRecord;
    }

    public void setTimeOfRecord(String timeOfRecord) {
        this.timeOfRecord = timeOfRecord;
    }

    public String getTimeOfLastUpdate() {
        return timeOfLastUpdate;
    }

    public void setTimeOfLastUpdate(String timeOfLastUpdate) {
        this.timeOfLastUpdate = timeOfLastUpdate;
    }

    public SourceOfFunds getSourceOfFunds() {
        return sourceOfFunds;
    }

    public void setSourceOfFunds(SourceOfFunds sourceOfFunds) {
        this.sourceOfFunds = sourceOfFunds;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getGatewayEntryPoint() {
        return gatewayEntryPoint;
    }

    public void setGatewayEntryPoint(String gatewayEntryPoint) {
        this.gatewayEntryPoint = gatewayEntryPoint;
    }

    public AuthorizationResponse getAuthorizationResponse() {
        return authorizationResponse;
    }

    public void setAuthorizationResponse(AuthorizationResponse authorizationResponse) {
        this.authorizationResponse = authorizationResponse;
    }
}
