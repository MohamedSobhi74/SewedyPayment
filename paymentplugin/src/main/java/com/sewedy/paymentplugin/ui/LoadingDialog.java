package com.sewedy.paymentplugin.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.fragment.app.DialogFragment;

import com.sewedy.paymentplugin.R;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class LoadingDialog extends DialogFragment {


    int tag_incress = 1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loader_layout, container, false);
        Objects.requireNonNull(Objects.requireNonNull(getDialog()).getWindow()).requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(false);
        Objects.requireNonNull(getDialog().getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        return view;
    }
    @Override
    public void onCancel(@NotNull DialogInterface dialog) {
        super.onCancel(dialog);
        requireActivity().finish();
    }




}
