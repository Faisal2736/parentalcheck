package blutechnologies.com.parentalcontrol.uiActivities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import blutechnologies.com.parentalcontrol.R;

public class WelcomeAcitivty extends AppCompatActivity {
    private Button btn_SignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_acitivty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // init views
        btn_SignIn = findViewById(R.id.btn_sign_in);


    }

}
