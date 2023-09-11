package com.sewedy.paymentplugin.models.pay.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sewedy.paymentplugin.models.pay.Order;
import com.sewedy.paymentplugin.models.pay.SourceOfFunds;

public  class PayRequest {

    @Expose
    @SerializedName("order")
    private Order order;
    @Expose
    @SerializedName("sourceOfFunds")
    private SourceOfFunds sourceOfFunds;
    @Expose
    @SerializedName("apiOperation")
    private String apiOperation;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public SourceOfFunds getSourceOfFunds() {
        return sourceOfFunds;
    }

    public void setSourceOfFunds(SourceOfFunds sourceOfFunds) {
        this.sourceOfFunds = sourceOfFunds;
    }

    public String getApiOperation() {
        return apiOperation;
    }

    public void setApiOperation(String apiOperation) {
        this.apiOperation = apiOperation;
    }
}
