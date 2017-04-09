package bphc.com.nirmaan;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import bphc.com.nirmaan.app.Constants;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.VolBlank;
import bphc.com.nirmaan.object.VolMcq;
import bphc.com.nirmaan.object.VolTruefalse;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 */
public class VolQuestionBankActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Context context;

    RealmResults<VolMcq> mcqList;
    RealmResults<VolBlank> blanks;
    RealmResults<VolTruefalse> tfList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_question_bank);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


        mcqList = new DBTransactions(this)
                .getVolMcqs(getIntent().getExtras().getLong(Constants.KEY_VOLUNTEER_TIME));
        blanks = new DBTransactions(this)
                .getVolBlanks(getIntent().getExtras().getLong(Constants.KEY_VOLUNTEER_TIME));
        tfList = new DBTransactions(this)
                .getVolTrueFalse(getIntent().getExtras().getLong(Constants.KEY_VOLUNTEER_TIME));

        if(mcqList.isEmpty()){
            adapter.addFragment(new NoQuestionsFragment(),"MCQ");
        }
        else{
            adapter.addFragment(new VolMCQFragment(), "MCQ");
        }
        if(blanks.isEmpty()) {
            adapter.addFragment(new NoQuestionsFragment(),"FIB");
        }
        else{
            adapter.addFragment(new VolBlankFragment(), "FIB");
        }
        if(tfList.isEmpty())
        {
            adapter.addFragment(new NoQuestionsFragment(),"TF");
        }
        else{
            adapter.addFragment(new VolTFFragment(), "TF");
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
