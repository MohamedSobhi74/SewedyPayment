package com.sewedy.paymentplugin.models.pay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Provided {
    @Expose
    @SerializedName("card")
    private Card card;

    public Provided(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
