package com.sewedy.paymentplugin.utils;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

import kotlin.text.Regex;

public class CreditCardNumberFormattingTextWatcher implements TextWatcher {

    private char space = ' ';

    public CreditCardNumberFormattingTextWatcher(char space) {
        this.space = space;
    }
    // Change this to what you want... ' ', '-' etc..


    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        // Remove spacing char
        if (s.length() > 0 && (s.length() % 5) == 0) {
            final char c = s.charAt(s.length() - 1);
            if (space == c) {
                s.delete(s.length() - 1, s.length());
            }
            // Insert char where needed.
            // Only if its a digit where there should be a space we insert a space
            if (Character.isDigit(c) && TextUtils.split(s.toString(), String.valueOf(space)).length <= 3) {
                s.insert(s.length() - 1, String.valueOf(space));

            }
        }

    }
}