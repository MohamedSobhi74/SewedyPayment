package com.sewedy.paymentplugin.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.sewedy.paymentplugin.R;

public class CustomAlertDialog extends Dialog implements View.OnClickListener {

    private  Button okBtn;
    private  TextView titleTv, messageTv;


    protected CustomAlertDialog(@NonNull Context context) {
        super(context,R.style.DialogTheme);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        setCancelable(false);
        setContentView(R.layout.success_dialog);

        titleTv = findViewById(R.id.textTitle);
        messageTv = findViewById(R.id.textMessage);
        okBtn = (Button) findViewById(R.id.buttonAction);
        okBtn.setOnClickListener(this);
    }

    void setDialogTitle(String title){
        titleTv.setText(title);
    }
    void setMessageTv(String msg){
        messageTv.setText(msg);
    }


    @Override
    public void onClick(View view) {
        dismiss();
    }
}
