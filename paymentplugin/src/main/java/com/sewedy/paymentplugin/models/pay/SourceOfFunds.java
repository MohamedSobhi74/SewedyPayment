package com.sewedy.paymentplugin.models.pay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceOfFunds {
    @Expose
    @SerializedName("type")
    private String type;
    @Expose
    @SerializedName("provided")
    private Provided provided;

    public SourceOfFunds(String type, Provided provided) {
        this.type = type;
        this.provided = provided;
    }

    public Provided getProvided() {
        return provided;
    }

    public void setProvided(Provided provided) {
        this.provided = provided;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
