package bphc.com.nirmaan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bphc.com.nirmaan.adapter.StuBlankAdapter;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.StuBlank;
import io.realm.RealmResults;

/**
 * Created by sarath on 05-02-2017.
 */

public class StuBlankFragment extends Fragment {

    RealmResults<StuBlank> blanks;
    RecyclerView blankRecycler;

    public StuBlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Get the Realm StuBlank object from the database!
        /*blanks = new DBTransactions(getActivity())
                .getStuBlanks(getActivity().getIntent().getExtras().getString(Constants.KEY_STUDENT_SUBJECT),
                        getActivity().getIntent().getExtras().getInt(Constants.KEY_STUDENT_TOPIC_ID));
*/
        blanks = new DBTransactions(getActivity())
                .getStuBlanks("English",1);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stu_blank, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        blankRecycler = (RecyclerView) view.findViewById(R.id.recycler_view_stu_blank);
        blankRecycler.setAdapter(new StuBlankAdapter(getActivity(),blanks));
        blankRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
