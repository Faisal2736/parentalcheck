package blutechnologies.com.parentalcontrol.uiActivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import blutechnologies.com.parentalcontrol.R;
import blutechnologies.com.parentalcontrol.adapters.ChildMessagingAdap;
import blutechnologies.com.parentalcontrol.dataModels.ChildMessagingDm;

public class ChildMessengerActivity extends AppCompatActivity {

    private RecyclerView recyclerView_messages;
    private LinearLayoutManager linearLayoutManager;
    private ChildMessagingAdap childMessagingAdap;
    private List<ChildMessagingDm> childMessagingDms = new ArrayList<>();

    private Button btn_schedule;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_messenger);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();

        btn_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChildMessagingDm messagingDm = new ChildMessagingDm();
                messagingDm.setMessage("Hello from jarvis");
                childMessagingDms.add(messagingDm);
                childMessagingAdap.notifyDataSetChanged();


            }
        });

        linearLayoutManager = new LinearLayoutManager(ChildMessengerActivity.this, LinearLayoutManager.VERTICAL, false);
        childMessagingAdap = new ChildMessagingAdap(ChildMessengerActivity.this);
        childMessagingAdap.LoadNewData(childMessagingDms);
        recyclerView_messages.setLayoutManager(linearLayoutManager);
        recyclerView_messages.setAdapter(childMessagingAdap);


    }

    private void initViews() {
        recyclerView_messages = findViewById(R.id.recyclerView_messages);
        btn_schedule = findViewById(R.id.btn_schedule);
    }

}
