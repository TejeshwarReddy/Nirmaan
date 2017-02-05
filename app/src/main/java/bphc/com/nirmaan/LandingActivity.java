package bphc.com.nirmaan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import bphc.com.nirmaan.app.LoginPrefs;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.VolMcq;
import bphc.com.nirmaan.service.FeedVolunteerDataService;
import io.realm.RealmResults;

public class LandingActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = "LandingActivity";
    DBTransactions transactions;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        startService(new Intent(this, FeedVolunteerDataService.class));

        if (savedInstanceState == null) {
            VolScheduleFragment fragment = new VolScheduleFragment();
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.container, fragment).commit();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        transactions = new DBTransactions(this);
        RealmResults<VolMcq> volMcqs = transactions.getMcqs(1486073208000l);
        for (int i = 0; i< volMcqs.size(); i++){
            Log.e(TAG, volMcqs.get(i).getQuestion());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch(id){
            case R.id.nav_class_schedule:
                break;
            case R.id.nav_logout:
                startActivity(new Intent(LandingActivity.this,LoginActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK));
                LoginPrefs.setPrefs(this,null,null,-1,-1);
                break;
        }
        drawer.closeDrawer(GravityCompat.END);
        return true;
    }
}
