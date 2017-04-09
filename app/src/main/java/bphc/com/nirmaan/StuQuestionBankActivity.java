package bphc.com.nirmaan;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import bphc.com.nirmaan.app.Constants;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.StuBlank;
import bphc.com.nirmaan.object.StuMcq;
import bphc.com.nirmaan.object.StuTruefalse;
import bphc.com.nirmaan.service.FeedStudentDataService;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 */
public class StuQuestionBankActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Context context;

    RealmResults<StuTruefalse> tfs;
    RealmResults<StuMcq> mcqs;
    RealmResults<StuBlank> blanks;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_bank);

        startService(new Intent(this, FeedStudentDataService.class));
        Log.e("TDSK ERROR GENERATOR", "FeedStudentDataService Started");

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        mcqs = new DBTransactions(this)
                .getStuMcqs(getIntent().getExtras().getString(Constants.KEY_STUDENT_SUBJECT),
                        getIntent().getExtras().getString(Constants.KEY_STUDENT_TOPIC_ID));

        tfs = new DBTransactions(this)
                .getStuTF(getIntent().getExtras().getString(Constants.KEY_STUDENT_SUBJECT),
                        getIntent().getExtras().getString(Constants.KEY_STUDENT_TOPIC_ID));

        blanks = new DBTransactions(this)
                .getStuBlanks(getIntent().getExtras().getString(Constants.KEY_STUDENT_SUBJECT),
                        getIntent().getExtras().getString(Constants.KEY_STUDENT_TOPIC_ID));

        if(mcqs.isEmpty()){
            adapter.addFragment(new NoQuestionsFragment(),"MCQ");
        }
        else{
            adapter.addFragment(new StuMCQFragment(), "MCQ");
        }
        if(blanks.isEmpty()) {
            adapter.addFragment(new NoQuestionsFragment(),"FIB");
        }
        else{
            adapter.addFragment(new StuBlankFragment(), "FIB");
        }
        if(tfs.isEmpty())
        {
            adapter.addFragment(new NoQuestionsFragment(),"TF");
        }
        else{
            adapter.addFragment(new StuTFFragment(), "TF");
        }

        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }



    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
