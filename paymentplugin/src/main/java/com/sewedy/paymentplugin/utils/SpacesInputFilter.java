package com.sewedy.paymentplugin.utils;

import android.text.InputFilter;
import android.text.Spanned;

public class SpacesInputFilter implements InputFilter {

    private final int max;
    private final int[] spaces;
    private final char space;

    public SpacesInputFilter(int max, int[] spaces, char space) {
        this.max = max;
        this.spaces = spaces;
        this.space = space;
    }

    public CharSequence filter(CharSequence source,
                               int start,
                               int end,
                               Spanned dest,
                               int dstart,
                               int dend) {
        if (dest != null && dest.toString().trim().length() > max) {
            return null;
        }
        if (source.length() == 1 && contains(dstart, spaces) && source.charAt(0) != space) {
            return space + source.toString();
        }

        //copy-paste case
        int spacesCount = 0;
        if (start == 0 && source.length() == end) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                char symbol = source.charAt(i);
                if (contains(i + spacesCount, spaces) && symbol != space) {
                    spacesCount++;
                    sb.append(space);
                }
                sb.append(symbol);
            }
            return sb.toString();
        }
        //unhandled: partial copy-paste
        return null; // keep original
    }

    private boolean contains(int i, int[] array) {
        for (int j: array) {
            if (j == i) {
                return true;
            }
        }
        return false;
    }
}