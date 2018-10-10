package blutechnologies.com.parentalcontrol.uiActivities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import blutechnologies.com.parentalcontrol.R;
import blutechnologies.com.parentalcontrol.dataModels.RegisterResponse;
import blutechnologies.com.parentalcontrol.utils.Constants;
import blutechnologies.com.parentalcontrol.webServices.ApiClient;
import blutechnologies.com.parentalcontrol.webServices.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParentSignupPasswordActivity extends AppCompatActivity {

    Button createAccount;

    TextInputLayout passwordTextInput;
    TextInputLayout confirmPasswordTextInput;

    EditText password;
    EditText confirmPassword;

    String firstName;
    String lastName;
    String email;
    SharedPreferences prefLogIn;
    SharedPreferences.Editor editor;
    private ProgressDialog progressDialog;
    private ApiInterface apiInterface;
    private Call<RegisterResponse> registerCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_signup_password);

        Bundle bundle = getIntent().getExtras();
        firstName = bundle.getString("firstName");
        lastName = bundle.getString("lastName");
        email = bundle.getString("email");

        changeStatusBarColor();
        initViews();
        initListeners();
    }

    private void initViews() {

        createAccount = findViewById(R.id.createAccount);

        passwordTextInput = findViewById(R.id.passwordTextInput);
        confirmPasswordTextInput = findViewById(R.id.confirmPasswordTextInput);

        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);

        prefLogIn = getSharedPreferences(Constants.MY_PREF_LOGIN, Context.MODE_PRIVATE);

        progressDialog = new ProgressDialog(this, R.style.exitDialogTheme);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
    }

    private void initListeners() {

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (password.getText().toString().isEmpty()) {
                    passwordTextInput.setErrorEnabled(true);
                    passwordTextInput.setError("Password name cannot be empty");
                    return;
                } else {
                    passwordTextInput.setErrorEnabled(false);
                }

                if (password.getText().toString().length() < 6) {
                    passwordTextInput.setErrorEnabled(true);
                    passwordTextInput.setError("Password must be atleast 6 characters");
                    return;
                } else {
                    passwordTextInput.setErrorEnabled(false);
                }

                if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
                    confirmPasswordTextInput.setErrorEnabled(true);
                    confirmPasswordTextInput.setError("Password mistatch");
                    return;
                } else {
                    confirmPasswordTextInput.setErrorEnabled(false);
                }

                progressDialog.show();
                apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
                registerCall = apiInterface.registerAPI(firstName, lastName, email,
                        password.getText().toString(), confirmPassword.getText().toString());

                registerCall.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                        progressDialog.dismiss();
                        RegisterResponse registerResponse = response.body();

                        if (response.isSuccessful()) {

                            if (registerResponse != null) {
                                if (registerResponse.isSuccess()) {

                                    editor = prefLogIn.edit();
                                    editor.putString(Constants.PREF_USER_TOKEN, registerResponse.getAccess_token());
                                    editor.commit();
                                    editor.apply();

                                    Intent intent = new Intent(ParentSignupPasswordActivity.this, ParentActivationCodeActivity.class);
                                    startActivity(intent);
                                } else {
                                    if (registerResponse.getError() != null) {
                                        if (registerResponse.getError().getEmail() != null) {
                                            if (registerResponse.getError().getEmail().size() > 0) {
                                                Toast.makeText(ParentSignupPasswordActivity.this,
                                                        registerResponse.getError().getEmail().get(0), Toast.LENGTH_SHORT).show();
                                            } else {
                                                Toast.makeText(ParentSignupPasswordActivity.this,
                                                        "Something went wrong1", Toast.LENGTH_SHORT).show();
                                            }
                                        } else {
                                            Toast.makeText(ParentSignupPasswordActivity.this,
                                                    "Something went wrong2", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        Toast.makeText(ParentSignupPasswordActivity.this,
                                                "Something went wrong3", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            } else {
                                Toast.makeText(ParentSignupPasswordActivity.this,
                                        "Something went wrong4", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(ParentSignupPasswordActivity.this,
                                    "Something went wrong5", Toast.LENGTH_SHORT).show();
                            Log.d("baches", "onResponse: " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {

                        progressDialog.dismiss();
                        Toast.makeText(ParentSignupPasswordActivity.this, "Network Problem", Toast.LENGTH_SHORT).show();
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
