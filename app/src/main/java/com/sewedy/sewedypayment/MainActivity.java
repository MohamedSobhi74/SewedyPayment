package com.sewedy.sewedypayment;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.sewedy.paymentplugin.ui.PaymentPluginActivity;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, PaymentPluginActivity.class);
        Bundle bundle = new Bundle();
        // testing
      /*  bundle.putString("username", "TESTMERCHTST_EGP");
        bundle.putString("password", "26c176246ea2389bea43649c5e1d426e");
        bundle.putString("orderId", UUID.randomUUID().toString());
        bundle.putString("transactionId", UUID.randomUUID().toString());
*/
        // live
        bundle.putString("username", "PETROCHARGE");
        bundle.putString("password", "7a91d76b5e35d6ccf49aad04d727f5bd");
        bundle.putString("orderId", UUID.randomUUID().toString());
        bundle.putString("transactionId", UUID.randomUUID().toString());

        intent.putExtras(bundle);
        someActivityResultLauncher.launch(intent);

    }

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    // There are no request codes
                    Intent data = result.getData();
                    // Log.d("TAG", data.getAction());
                    // doSomeOperations();
                } else {
                    Log.d("TAG", ": failed");
                }
            });

}