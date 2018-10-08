package blutechnologies.com.parentalcontrol.uiActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import blutechnologies.com.parentalcontrol.R;

public class ChildSiginPasswordActivity extends AppCompatActivity {
    private Button btn_nextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin_password);
        btn_nextPassword = findViewById(R.id.btn_nextPassword);

        btn_nextPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildSiginPasswordActivity.this, DevicesSetupActivity.class);
                startActivity(intent);
            }
        });

    }

}
