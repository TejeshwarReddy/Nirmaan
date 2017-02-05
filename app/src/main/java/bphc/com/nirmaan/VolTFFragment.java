package bphc.com.nirmaan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bphc.com.nirmaan.adapter.VolTFAdapter;
import bphc.com.nirmaan.app.Constants;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.VolTruefalse;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class VolTFFragment extends Fragment {


    RecyclerView tfrecycler;
    RealmResults<VolTruefalse> tfList;
    public VolTFFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tfList = new DBTransactions(getActivity())
                .getVolTrueFalse(getActivity().getIntent().getExtras().getLong(Constants.KEY_VOLUNTEER_TIME));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vol_tf, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tfrecycler = (RecyclerView) view.findViewById(R.id.recycler_view_vol_tf);
        tfrecycler.setAdapter(new VolTFAdapter(getActivity(), tfList));
        tfrecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
