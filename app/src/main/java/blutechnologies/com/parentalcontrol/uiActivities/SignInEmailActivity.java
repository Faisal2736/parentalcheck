package blutechnologies.com.parentalcontrol.uiActivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import blutechnologies.com.parentalcontrol.R;

public class SignInEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_email);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
