package com.sewedy.paymentplugin.models.pay;

import java.io.Serializable;

public class PaymentResult implements Serializable {
    String transactionId, merchant, amount, transactionDate;
    boolean status = false;

    public PaymentResult(String transactionId, String merchant, String amount, String transactionDate) {
        this.transactionId = transactionId;
        this.merchant = merchant;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
