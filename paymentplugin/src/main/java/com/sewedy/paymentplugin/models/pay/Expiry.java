package com.sewedy.paymentplugin.models.pay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Expiry {
    @Expose
    @SerializedName("year")
    private String year;
    @Expose
    @SerializedName("month")
    private String month;

    public Expiry(String year, String month) {
        this.year = year;
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
