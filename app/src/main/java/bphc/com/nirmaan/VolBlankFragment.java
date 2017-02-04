package bphc.com.nirmaan;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bphc.com.nirmaan.adapter.VolBlankAdapter;
import bphc.com.nirmaan.app.Constants;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.VolBlank;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 */
public class VolBlankFragment extends Fragment {

    RealmResults<VolBlank> blanks;
    RecyclerView blankRecycler;

    public VolBlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Get the Realm Blank object from the database!
        blanks = new DBTransactions(getActivity())
                .getBlanks(getActivity().getIntent().getExtras().getLong(Constants.KEY_VOLUNTEER_TIME));

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vol_blank, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        blankRecycler = (RecyclerView) view.findViewById(R.id.recycler_view_vol_blank);
        blankRecycler.setAdapter(new VolBlankAdapter(getActivity(),blanks));
        blankRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
