package com.sewedy.paymentplugin.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sewedy.paymentplugin.R;
import com.sewedy.paymentplugin.databinding.ActivityPaymentPluginBinding;
import com.sewedy.paymentplugin.models.pay.Card;
import com.sewedy.paymentplugin.models.pay.Expiry;
import com.sewedy.paymentplugin.models.pay.Order;
import com.sewedy.paymentplugin.models.pay.PaymentResult;
import com.sewedy.paymentplugin.models.pay.request.PayRequest;
import com.sewedy.paymentplugin.models.pay.Provided;
import com.sewedy.paymentplugin.models.pay.SourceOfFunds;
import com.sewedy.paymentplugin.utils.Constants;
import com.sewedy.paymentplugin.utils.CreditCardNumberFormattingTextWatcher;
import com.sewedy.paymentplugin.utils.SpacesInputFilter;

public class PaymentPluginActivity extends AppCompatActivity {

    ActivityPaymentPluginBinding binding;
    PaymentViewModel paymentViewModel;
    private LoadingDialog loadingDialog;
    CustomAlertDialog customAlertDialog;
    private boolean isFront;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payment_plugin);
        initAuthData();
        paymentViewModel = new ViewModelProvider(this).get(PaymentViewModel.class);
        loadingDialog = new LoadingDialog();
        customAlertDialog = new CustomAlertDialog(this);
/*
        binding.cardNumInput.getEditText().setFilters(new InputFilter[]{
                new InputFilter.LengthFilter(19),
                new SpacesInputFilter(23, new int[]{4, 9, 14, 19}, ' ')
        });
*/

        // disable paste for credit card edittext
        binding.cardNumInput.getEditText().setOnLongClickListener(v -> true);
        // split text of credit card edittext
        binding.cardNumInput.getEditText().addTextChangedListener(new CreditCardNumberFormattingTextWatcher(' '));

        binding.payBtn.setOnClickListener(view -> validateCardDetails());
        observePAyOperation();
        observeError();
    }

    private void initAuthData() {
        Bundle bundle = getIntent().getExtras();
        Constants.username = bundle.getString("username");
        Constants.password = bundle.getString("password");

        String amount = getIntent().getExtras().getString("amount");
        binding.amountInput.getEditText().setText(amount);
        /*ApplicationInfo ai = null;
        try {
            ai = getPackageManager().getApplicationInfo(this.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }*/

        Animator front_animation = AnimatorInflater.loadAnimator(this, R.animator.front_animator);
        Animator back_animation = AnimatorInflater.loadAnimator(this, R.animator.back_animator);

/*
        binding.cvvInput.getEditText().setOnFocusChangeListener((view, b) -> {
            if (b) {
                binding.backCard.animate().rotationYBy(180).withEndAction(new Runnable(){
                    @Override
                    public void run() {
                        card.setImageResource(android.R.drawable.ic_dialog_alert);
                    }
                });
            } else {
                front_animation.setTarget(binding.backCard);
                back_animation.setTarget(binding.frontCard);
                front_animation.start();
                back_animation.start();
                isFront = true;
            }
        });
*/

    }

    private void observeError() {
        paymentViewModel.errorResponseMutableLiveData.observe(this, errorResponse -> {
            dismissLoadingProgress();
            Toast.makeText(this, errorResponse.getError().getExplanation() + "\n" + errorResponse.getError().getExplanation(), Toast.LENGTH_SHORT).show();
        });

    }

    private void observePAyOperation() {
        paymentViewModel.payResponseMutableLiveData.observe(this, payResponse -> {
            dismissLoadingProgress();

            Intent returnIntent = new Intent();
            Bundle bundle = new Bundle();
            //getIntent().getExtras().putString("amount", String.valueOf(payResponse.getOrder().getAmount()));
            customAlertDialog.setDialogTitle(getString(R.string.success));
            customAlertDialog.setMessageTv(getString(R.string.transaction_success_msg));
            customAlertDialog.show();
            customAlertDialog.setOnDismissListener(dialogInterface -> {

                PaymentResult paymentResult = new PaymentResult(payResponse.getTransaction().getId(),
                        payResponse.getMerchant(),
                        String.valueOf(payResponse.getTransaction().getAmount()),
                        payResponse.getTimeOfRecord());

                paymentResult.setStatus(true);
                bundle.putSerializable("paymentResult", paymentResult);
                returnIntent.putExtras(bundle);
                setResult(Activity.RESULT_OK, returnIntent);
                onBackPressed();

            });
        });
    }

    private void validateCardDetails() {
        String holderName = binding.holderNameInput.getEditText().getText().toString();
        String cardNum = binding.cardNumInput.getEditText().getText().toString().replace(" ", "");
        String amount = binding.amountInput.getEditText().getText().toString();
        String expiryMonth = binding.expiryMonthInput.getEditText().getText().toString();
        String expiryYear = binding.expiryYearInput.getEditText().getText().toString();
        String securityCode = binding.cvvInput.getEditText().getText().toString();

        if (!cardNum.matches("[0-9]+") || TextUtils.isEmpty(cardNum) || cardNum.length() < 16) {
            binding.cardNumInput.getEditText().setError(getResources().getString(R.string.please_enter_card_num));
            binding.cardNumInput.getEditText().requestFocus();
            return;
        }

        if (TextUtils.isEmpty(amount)) {
            binding.amountInput.getEditText().setError(getResources().getString(R.string.please_enter_amount));
            binding.amountInput.getEditText().requestFocus();
            return;
        }

        if (TextUtils.isEmpty(expiryMonth)) {
            binding.expiryMonthInput.getEditText().setError(getResources().getString(R.string.please_enter_expiry_month));
            binding.expiryMonthInput.getEditText().requestFocus();
            return;
        }

        if (TextUtils.isEmpty(expiryYear)) {
            binding.expiryYearInput.getEditText().setError(getResources().getString(R.string.please_enter_expiry_year));
            binding.expiryYearInput.getEditText().requestFocus();
            return;
        }
        if (TextUtils.isEmpty(securityCode)) {
            binding.cvvInput.getEditText().setError(getResources().getString(R.string.please_enter_security_code));
            binding.cvvInput.getEditText().requestFocus();
            return;
        }

        fakeResponse();

       /*  showLoadingProgress();
      Order order = new Order(amount, Constants.paymentCurrency);
        Expiry expiry = new Expiry(expiryYear, expiryMonth);
        Card card = new Card(expiry, securityCode, cardNum);
        Provided provided = new Provided(card);
        SourceOfFunds sourceOfFunds = new SourceOfFunds("CARD", provided);

        PayRequest payRequest = new PayRequest();
        payRequest.setApiOperation("PAY");
        payRequest.setOrder(order);
        payRequest.setSourceOfFunds(sourceOfFunds);
        payOrder(payRequest);*/

    }

    public void fakeResponse(){
        customAlertDialog.setDialogTitle(getString(R.string.success));
        customAlertDialog.setMessageTv(getString(R.string.transaction_success_msg));
        customAlertDialog.show();
        customAlertDialog.setOnDismissListener(dialogInterface -> {
                    Intent returnIntent = new Intent();
                    Bundle bundle = new Bundle();

                    PaymentResult paymentResult = new PaymentResult("sdffds",
                            "asdasdasd",
                            String.valueOf("100"),
                            "");

                    paymentResult.setStatus(true);
                    bundle.putSerializable("paymentResult", paymentResult);
                    returnIntent.putExtras(bundle);
                    setResult(Activity.RESULT_OK, returnIntent);
                    onBackPressed();
                });
        //
    }
    private void payOrder(PayRequest payRequest) {
        String orderId = getIntent().getExtras().getString("orderId");
        String transactionId = getIntent().getExtras().getString("transactionId");
        paymentViewModel.pay(Constants.username, orderId, transactionId, payRequest);
    }

    /*
        protected void showSuccessDialog() {
            try {
                customAlertDialog.show(((AppCompatActivity) this).getSupportFragmentManager(), "success");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    */
    protected void showLoadingProgress() {
        try {
            loadingDialog.show(((AppCompatActivity) this).getSupportFragmentManager(), "showLoading");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismissLoadingProgress() {
        try {
            if (loadingDialog != null)
                loadingDialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}