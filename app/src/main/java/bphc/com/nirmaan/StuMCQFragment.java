package bphc.com.nirmaan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bphc.com.nirmaan.adapter.StuMcqAdapter;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.StuMcq;
import io.realm.RealmResults;

/**
 * Created by sarath on 05-02-2017.
 */

public class StuMCQFragment extends Fragment {

    RealmResults<StuMcq> mcqs;
    RecyclerView mcqRecycler;

    public StuMCQFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Get the Realm StuBlank object from the database!
       /* mcqs = new DBTransactions(getActivity())
                .getStuMcqs(getActivity().getIntent().getExtras().getString(Constants.KEY_STUDENT_SUBJECT),
                        getActivity().getIntent().getExtras().getInt(Constants.KEY_STUDENT_TOPIC_ID));*/

        mcqs = new DBTransactions(getActivity())
                .getStuMcqs("English","1");

        for (int i = 0;i<mcqs.size();i++){
            Log.e("Stumcqs10",mcqs.get(i).getQuestion());
        }


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stu_mcq, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mcqRecycler = (RecyclerView) view.findViewById(R.id.recycler_view_stu_mcq);
        mcqRecycler.setAdapter(new StuMcqAdapter(getActivity(), mcqs));
        mcqRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}