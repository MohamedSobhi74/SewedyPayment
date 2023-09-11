package com.sewedy.paymentplugin.models.pay.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Acquirer {
    @Expose
    @SerializedName("transactionId")
    private String transactionId;
    @Expose
    @SerializedName("timeZone")
    private String timeZone;
    @Expose
    @SerializedName("settlementDate")
    private String settlementDate;
    @Expose
    @SerializedName("merchantId")
    private String merchantId;
    @Expose
    @SerializedName("id")
    private String id;
    @Expose
    @SerializedName("date")
    private String date;
    @Expose
    @SerializedName("batch")
    private int batch;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }
}
