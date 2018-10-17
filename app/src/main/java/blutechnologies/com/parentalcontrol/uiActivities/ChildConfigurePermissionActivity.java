package blutechnologies.com.parentalcontrol.uiActivities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import blutechnologies.com.parentalcontrol.R;
import blutechnologies.com.parentalcontrol.utils.Constants;

import static android.Manifest.permission.READ_CONTACTS;


public class ChildConfigurePermissionActivity extends AppCompatActivity {
    private static final String TAG = "ChildConfigurePermissio";

    private RelativeLayout relativeLayout_activity_child_configure_permission;
    private Button btn_permission_enable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_configure_permission);

        initViews();


        btn_permission_enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                requestPermissions();

            }
        });


    }

    private void initViews() {
        relativeLayout_activity_child_configure_permission = findViewById(R.id.relativeLayout_activity_child_configure_permission);
        btn_permission_enable = findViewById(R.id.btn_permission_enable);
    }

    public void requestPermissions() {
        String[] permissions = {
                Manifest.permission.INTERNET,
                READ_CONTACTS,
                Manifest.permission.WRITE_CONTACTS,
                Manifest.permission.READ_CALL_LOG,
                Manifest.permission.WRITE_CALL_LOG,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.READ_SMS,
                Manifest.permission.SEND_SMS,
                Manifest.permission.RECEIVE_SMS,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        Log.d(TAG, "requestPermissions: " + "is called");
        ActivityCompat.requestPermissions(this, permissions, Constants.PERMISSIONS_REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull final String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: " + grantResults.length);


        boolean allGranted = true;
        if (grantResults.length > 0) {
            for (int granResult : grantResults) {
                Log.d(TAG, "onRequestPermissionsResult: " + granResult + "\n");
                if (granResult != PackageManager.PERMISSION_GRANTED) {
                    allGranted = false;
                    break;
                }

            }
        }
        if (allGranted) {
            startStayConnectedActivity();
        } else {
            Snackbar.make(relativeLayout_activity_child_configure_permission,
                    "Please Grant All Permission to Continue", Snackbar.LENGTH_INDEFINITE).setAction("Grant", new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (ActivityCompat.shouldShowRequestPermissionRationale(ChildConfigurePermissionActivity.this, READ_CONTACTS) ||
                            ActivityCompat.shouldShowRequestPermissionRationale(ChildConfigurePermissionActivity.this, Manifest.permission.READ_CALL_LOG) ||
                            ActivityCompat.shouldShowRequestPermissionRationale(ChildConfigurePermissionActivity.this, Manifest.permission.WRITE_CALL_LOG) ||
                            ActivityCompat.shouldShowRequestPermissionRationale(ChildConfigurePermissionActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ||
                            ActivityCompat.shouldShowRequestPermissionRationale(ChildConfigurePermissionActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) ||
                            ActivityCompat.shouldShowRequestPermissionRationale(ChildConfigurePermissionActivity.this, Manifest.permission.READ_PHONE_STATE) ||
                            ActivityCompat.shouldShowRequestPermissionRationale(ChildConfigurePermissionActivity.this, Manifest.permission.READ_SMS) ||
                            ActivityCompat.shouldShowRequestPermissionRationale(ChildConfigurePermissionActivity.this, Manifest.permission.SEND_SMS)) {
                        ActivityCompat.requestPermissions(ChildConfigurePermissionActivity.this, permissions, Constants.PERMISSIONS_REQUEST_CODE);

                    } else {
                        Intent intentSetting = new Intent();
                        intentSetting.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", ChildConfigurePermissionActivity.this.getPackageName(), null);
                        intentSetting.setData(uri);
                        startActivity(intentSetting);
                    }


                }


            }).show();

        }


    }

    private void startStayConnectedActivity() {

        Intent intent = new Intent(ChildConfigurePermissionActivity.this, ChildStayConnectedBackgroundActivity.class);
        startActivity(intent);
    }
}
