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

public class ParentSignupEmailActivity extends AppCompatActivity {

    Button btnNext;

    TextInputLayout firstNameTextInput;
    TextInputLayout lastNameTextInput;
    TextInputLayout emailTextInput;

    EditText firstName;
    EditText lastName;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_signup_email);

        changeStatusBarColor();
        initViews();
        initListeners();
    }

    private void initViews() {

        btnNext = findViewById(R.id.btnNext);

        firstNameTextInput = findViewById(R.id.firstNameTextInput);
        lastNameTextInput = findViewById(R.id.lastNameTextInput);
        emailTextInput = findViewById(R.id.emailTextInput);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
    }

    private void initListeners() {

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (email.getText().toString().isEmpty() || firstName.getText().toString().isEmpty() ||
                        lastName.getText().toString().isEmpty()) {

                    if (firstName.getText().toString().isEmpty()) {
                        firstNameTextInput.setErrorEnabled(true);
                        firstNameTextInput.setError("First name cannot be empty");
                    } else {
                        firstNameTextInput.setErrorEnabled(false);
                    }

                    if (lastName.getText().toString().isEmpty()) {
                        lastNameTextInput.setErrorEnabled(true);
                        lastNameTextInput.setError("Last name cannot be empty");
                    } else {
                        lastNameTextInput.setErrorEnabled(false);
                    }

                    if (email.getText().toString().isEmpty()) {
                        emailTextInput.setErrorEnabled(true);
                        emailTextInput.setError("Email name cannot be empty");
                    } else {
                        emailTextInput.setErrorEnabled(false);
                    }

                    return;
                }

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                    emailTextInput.setErrorEnabled(true);
                    emailTextInput.setError("Please enter valid email address");
                    return;
                } else {
                    emailTextInput.setErrorEnabled(false);
                }

                Intent intent = new Intent(ParentSignupEmailActivity.this, ParentSignupPasswordActivity.class);
                intent.putExtra("firstName", firstName.getText().toString().isEmpty());
                intent.putExtra("lastName", lastName.getText().toString().isEmpty());
                intent.putExtra("email", email.getText().toString().isEmpty());
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
