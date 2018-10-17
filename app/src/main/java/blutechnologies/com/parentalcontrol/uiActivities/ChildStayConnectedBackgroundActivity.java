package blutechnologies.com.parentalcontrol.uiActivities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import blutechnologies.com.parentalcontrol.R;
import blutechnologies.com.parentalcontrol.utils.Constants;
import blutechnologies.com.parentalcontrol.utils.Dialogs;

public class ChildStayConnectedBackgroundActivity extends AppCompatActivity {
    private static final String TAG = "ChildStayConnectedBackg";
    private Button btn_stay_connected_enable;
    private boolean granted = false;
    private PowerManager pm;
    private String packageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_stay_connected_background);
        pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        packageName = getApplicationContext().getPackageName();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            granted = pm.isIgnoringBatteryOptimizations(packageName);
            Log.d(TAG, "helo: " + granted);
        } else {
            granted = false;
        }


        initViews();

        btn_stay_connected_enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (granted) {
                    startAppstatisticActivtiy();
                } else {


                    Dialogs.DialogPositiveButton dialogPositiveButton = new Dialogs.DialogPositiveButton(ChildStayConnectedBackgroundActivity.this,
                            getString(R.string.stay_background_instruction)
                            , "    OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intentSetting = new Intent();

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                intentSetting.setAction(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
                                startActivityForResult(intentSetting, Constants.BATTERY_OPTIMIZATION_CODE);

                            }


                        }
                    });

                    dialogPositiveButton.show(getSupportFragmentManager(), "1");
                }

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(TAG, "helo: " + requestCode + resultCode);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            granted = pm.isIgnoringBatteryOptimizations(packageName);
            Log.d(TAG, "helo: " + granted);
        } else {
            granted = false;
        }


    }

    private void startAppstatisticActivtiy() {
        Intent intentStatActivity = new Intent(ChildStayConnectedBackgroundActivity.this, ChildAppStatisticActivity.class);
        startActivity(intentStatActivity);

    }

    private void initViews() {

        btn_stay_connected_enable = findViewById(R.id.btn_stay_connected_enable);
    }


}
