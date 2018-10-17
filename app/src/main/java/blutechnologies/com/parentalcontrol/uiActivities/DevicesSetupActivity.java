package blutechnologies.com.parentalcontrol.uiActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import blutechnologies.com.parentalcontrol.R;

public class DevicesSetupActivity extends AppCompatActivity {
    private Button btn_child_device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices_setup);
        //init viewa

        btn_child_device = findViewById(R.id.btn_child_device);

        btn_child_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentChildListActivity = new Intent(DevicesSetupActivity.this, ChildListActivity.class);
                startActivity(intentChildListActivity);

            }
        });
    }

}
