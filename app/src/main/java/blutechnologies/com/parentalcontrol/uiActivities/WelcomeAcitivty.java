package blutechnologies.com.parentalcontrol.uiActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import blutechnologies.com.parentalcontrol.R;

public class WelcomeAcitivty extends AppCompatActivity {

    private Button btn_SignIn;
    private Button btn_create_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_acitivty);
        // init views
        btn_SignIn = findViewById(R.id.btn_sign_in);
        btn_create_account = findViewById(R.id.btn_create_account);

        btn_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeAcitivty.this, ChildSignInEmailActivity.class);
                startActivity(intent);
            }
        });

        btn_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeAcitivty.this,ParentSignupEmailActivity.class);
                startActivity(intent);
            }
        });
    }

}
