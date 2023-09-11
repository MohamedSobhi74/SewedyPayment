package com.sewedy.paymentplugin.models.pay.error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorResponse {

    @Expose
    @SerializedName("result")
    private String result;
    @Expose
    @SerializedName("error")
    private Error error;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
