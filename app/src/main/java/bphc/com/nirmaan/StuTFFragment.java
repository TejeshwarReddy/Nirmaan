package bphc.com.nirmaan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bphc.com.nirmaan.adapter.StuTFAdapter;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.StuTruefalse;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class StuTFFragment extends Fragment {


    RecyclerView tfrecycler;
    RealmResults<StuTruefalse> tfList;
    public StuTFFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*tfList = new DBTransactions(getActivity())
                .getStuTF(getActivity().getIntent().getExtras().getString(Constants.KEY_STUDENT_SUBJECT),
                        getActivity().getIntent().getExtras().getInt(Constants.KEY_STUDENT_TOPIC_ID));*/

        tfList = new DBTransactions(getActivity())
                .getStuTF("English",1);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stu_tf, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tfrecycler = (RecyclerView) view.findViewById(R.id.recycler_view_stu_tf);
        tfrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        tfrecycler.setAdapter(new StuTFAdapter(getActivity(), tfList));
    }
}
