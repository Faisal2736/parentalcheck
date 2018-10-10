package blutechnologies.com.parentalcontrol.uiActivities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import blutechnologies.com.parentalcontrol.R;

public class ParentSignupPasswordActivity extends AppCompatActivity {

    Button createAccount;

    TextInputLayout passwordTextInput;
    TextInputLayout confirmPasswordTextInput;

    EditText password;
    EditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_signup_password);

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

                Intent intent = new Intent(ParentSignupPasswordActivity.this, ParentActivationCodeActivity.class);
                startActivity(intent);
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
