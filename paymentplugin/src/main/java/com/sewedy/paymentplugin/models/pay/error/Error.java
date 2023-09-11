package com.sewedy.paymentplugin.models.pay.error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error {
    @Expose
    @SerializedName("validationType")
    private String validationType;
    @Expose
    @SerializedName("field")
    private String field;
    @Expose
    @SerializedName("explanation")
    private String explanation;
    @Expose
    @SerializedName("cause")
    private String cause;

    public String getValidationType() {
        return validationType;
    }

    public void setValidationType(String validationType) {
        this.validationType = validationType;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
