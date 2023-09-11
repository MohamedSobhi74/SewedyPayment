package com.sewedy.paymentplugin.models.pay.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction {
    @Expose
    @SerializedName("type")
    private String type;
    @Expose
    @SerializedName("terminal")
    private String terminal;
    @Expose
    @SerializedName("stan")
    private String stan;
    @Expose
    @SerializedName("source")
    private String source;
    @Expose
    @SerializedName("receipt")
    private String receipt;
    @Expose
    @SerializedName("id")
    private String id;
    @Expose
    @SerializedName("currency")
    private String currency;
    @Expose
    @SerializedName("authorizationCode")
    private String authorizationCode;
    @Expose
    @SerializedName("authenticationStatus")
    private String authenticationStatus;
    @Expose
    @SerializedName("amount")
    private double amount;
    @Expose
    @SerializedName("acquirer")
    private Acquirer acquirer;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(String authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Acquirer getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Acquirer acquirer) {
        this.acquirer = acquirer;
    }
}
