package blutechnologies.com.parentalcontrol.uiActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import blutechnologies.com.parentalcontrol.R;

public class ChildHurrayActivity extends AppCompatActivity {

    private Button btn_hurray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_almost_done);

        btn_hurray = findViewById(R.id.btn_hurray);

        btn_hurray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChildHurrayActivity.this, ChildMessengerActivity.class);
                startActivity(intent);
            }
        });

    }


}
