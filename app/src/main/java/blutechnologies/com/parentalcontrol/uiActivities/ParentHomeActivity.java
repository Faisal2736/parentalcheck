package blutechnologies.com.parentalcontrol.uiActivities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import net.cachapa.expandablelayout.ExpandableLayout;

import blutechnologies.com.parentalcontrol.R;

public class ParentHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout internet_layout;
    LinearLayout location_layout;
    LinearLayout screen_layout;
    LinearLayout chats_layout;
    LinearLayout schedule_layout;
    LinearLayout call_layout;

    ExpandableLayout expandable_internet;
    ExpandableLayout expandable_location;
    ExpandableLayout expandable_screen;
    ExpandableLayout expandable_chats;
    ExpandableLayout expandable_schedule;
    ExpandableLayout expandable_calls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initViews();
        initListeners();
    }

    private void initViews() {

        internet_layout = findViewById(R.id.internet_layout);
        location_layout = findViewById(R.id.location_layout);
        screen_layout = findViewById(R.id.screen_layout);
        chats_layout = findViewById(R.id.chats_layout);
        schedule_layout = findViewById(R.id.schedule_layout);
        call_layout = findViewById(R.id.call_layout);

        expandable_internet = findViewById(R.id.expandable_internet);
        expandable_location = findViewById(R.id.expandable_location);
        expandable_screen = findViewById(R.id.expandable_screen);
        expandable_chats = findViewById(R.id.expandable_chats);
        expandable_schedule = findViewById(R.id.expandable_schedule);
        expandable_calls = findViewById(R.id.expandable_calls);
    }

    private void initListeners() {

        internet_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (expandable_internet.isExpanded()) {
                    expandable_internet.collapse();
                } else {
                    expandable_internet.expand();
                }
            }
        });

        location_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (expandable_location.isExpanded()) {
                    expandable_location.collapse();
                } else {
                    expandable_location.expand();
                }
            }
        });

        screen_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (expandable_screen.isExpanded()) {
                    expandable_screen.collapse();
                } else {
                    expandable_screen.expand();
                }
            }
        });

        chats_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (expandable_chats.isExpanded()) {
                    expandable_chats.collapse();
                } else {
                    expandable_chats.expand();
                }
            }
        });

        schedule_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (expandable_schedule.isExpanded()) {
                    expandable_schedule.collapse();
                } else {
                    expandable_schedule.expand();
                }
            }
        });

        call_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (expandable_calls.isExpanded()) {
                    expandable_calls.collapse();
                } else {
                    expandable_calls.expand();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.parent_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
