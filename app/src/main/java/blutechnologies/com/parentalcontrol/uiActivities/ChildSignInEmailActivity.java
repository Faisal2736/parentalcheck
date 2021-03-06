package blutechnologies.com.parentalcontrol.uiActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import blutechnologies.com.parentalcontrol.R;

public class ChildSignInEmailActivity extends AppCompatActivity {
    private Button btn_next_signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_email);
        btn_next_signIn = findViewById(R.id.btn_next_signIn);

        btn_next_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildSignInEmailActivity.this, ChildSiginPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

}
