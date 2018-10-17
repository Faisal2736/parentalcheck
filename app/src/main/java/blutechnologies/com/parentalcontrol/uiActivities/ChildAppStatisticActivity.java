package blutechnologies.com.parentalcontrol.uiActivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import blutechnologies.com.parentalcontrol.R;

public class ChildAppStatisticActivity extends AppCompatActivity {

    private Button btn_statistic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_app_statistic);

        btn_statistic = findViewById(R.id.btn_statistic);

        btn_statistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentChildStat = new Intent(ChildAppStatisticActivity.this, ChildHurrayActivity.class);
                startActivity(intentChildStat);
            }
        });

    }

}
