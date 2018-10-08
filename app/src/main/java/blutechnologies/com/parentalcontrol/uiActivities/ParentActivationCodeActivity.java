package blutechnologies.com.parentalcontrol.uiActivities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import blutechnologies.com.parentalcontrol.R;


public class ParentActivationCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_activation_code);

        changeStatusBarColor();
        initViews();
        initListeners();
    }

    private void initViews() {

//        createAccount = findViewById(R.id.createAccount);
    }

    private void initListeners() {

//        createAccount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(ParentSignupPasswordActivity.this, ParentActivationCodeActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.md_blue_600));
        }
    }
}
