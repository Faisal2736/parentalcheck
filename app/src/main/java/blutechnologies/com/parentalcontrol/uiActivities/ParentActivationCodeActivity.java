package blutechnologies.com.parentalcontrol.uiActivities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.poovam.pinedittextfield.LinePinField;

import blutechnologies.com.parentalcontrol.R;
import blutechnologies.com.parentalcontrol.dataModels.ActivationResponse;
import blutechnologies.com.parentalcontrol.utils.Constants;
import blutechnologies.com.parentalcontrol.webServices.ApiClient;
import blutechnologies.com.parentalcontrol.webServices.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ParentActivationCodeActivity extends AppCompatActivity {

    Button createAccount;
    LinePinField code;
    String user_token;
    private ApiInterface apiInterface;
    private Call<ActivationResponse> activationCall;
    private SharedPreferences sharedPreferences;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_activation_code);

        changeStatusBarColor();
        initViews();
        initListeners();
    }

    private void initViews() {

        createAccount = findViewById(R.id.createAccount);

        code = findViewById(R.id.code);

        sharedPreferences = getSharedPreferences(Constants.MY_PREF_LOGIN, Context.MODE_PRIVATE);
        user_token = sharedPreferences.getString(Constants.PREF_USER_TOKEN, null);

        progressDialog = new ProgressDialog(ParentActivationCodeActivity.this, R.style.exitDialogTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
    }

    private void initListeners() {

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (code.getText().toString().isEmpty()) {
                    Toast.makeText(ParentActivationCodeActivity.this, "Please enter verification code", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (code.getText().toString().length() < 6) {
                    Toast.makeText(ParentActivationCodeActivity.this, "Please enter 6 digit verification code", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressDialog.show();
                apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
                activationCall = apiInterface.activationAPI("Bearer " + user_token, code.getText().toString());

                activationCall.enqueue(new Callback<ActivationResponse>() {
                    @Override
                    public void onResponse(Call<ActivationResponse> call, Response<ActivationResponse> response) {

                        progressDialog.dismiss();
                        ActivationResponse activationResponse = response.body();

                        if (response.isSuccessful()) {

                            if (activationResponse != null) {
                                if (activationResponse.isSuccess()) {

                                    Intent intent = new Intent(ParentActivationCodeActivity.this, ChildNameActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(ParentActivationCodeActivity.this,
                                            "Code does not match.Please try again", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(ParentActivationCodeActivity.this,
                                        "Something went wrong", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(ParentActivationCodeActivity.this,
                                    "Something went wrong", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ActivationResponse> call, Throwable t) {

                        progressDialog.dismiss();
                        Toast.makeText(ParentActivationCodeActivity.this, "Network Problem", Toast.LENGTH_SHORT).show();
                        Log.d("baches", "onResponse: " + t.getMessage());
                    }
                });
            }
        });
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.md_blue_600));
        }
    }
}
