package bphc.com.nirmaan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import bphc.com.nirmaan.app.LoginPrefs;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.Mcq;
import bphc.com.nirmaan.object.TutorialClass;
import bphc.com.nirmaan.service.FeedDataService;
import bphc.com.nirmaan.object.VolMcq;
import bphc.com.nirmaan.service.FeedVolunteerDataService;
import io.realm.RealmResults;

public class LandingActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = "LandingActivity";
    DBTransactions transactions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        startService(new Intent(this, FeedVolunteerDataService.class));

        if (savedInstanceState == null) {
            TutClassFragment fragment = new TutClassFragment();
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.container, fragment).commit();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        transactions = new DBTransactions(this);
        RealmResults<VolMcq> volMcqs = transactions.getMcqs(1485948600000l);
        for (int i = 0; i< volMcqs.size(); i++){
            Log.e(TAG, volMcqs.get(i).getQuestion());
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.landing, menu);
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
        Fragment fragment;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch(id){
            case R.id.nav_class_schedule:

                break;
            case R.id.nav_question_bank:
                fragment = new QuestionBankFrangment();
                transaction.replace(R.id.content_landing,fragment);
                transaction.commit();
                break;
            case R.id.nav_logout:
                startActivity(new Intent(LandingActivity.this,LoginActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK));
                LoginPrefs.setPrefs(this,null,null,-1,-1);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
