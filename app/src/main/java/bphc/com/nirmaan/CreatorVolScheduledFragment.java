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

import java.util.List;

import bphc.com.nirmaan.adapter.CreatorAssignedAdapter;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.Volunteer;

import static bphc.com.nirmaan.LandingActivity.TAG;


public class CreatorVolScheduledFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private CreatorAssignedAdapter mCreatorAssignedAdapter;
    private DBTransactions mDbTransactions;

    public CreatorVolScheduledFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creator_vol_scheduled, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.vol_scheduled_list);

        mDbTransactions = new DBTransactions(getActivity());
        List<Volunteer> volunteerList = mDbTransactions.getAllVolunteersData();

        for (int i = 0; i< volunteerList.size(); i++){
            Log.e(TAG, volunteerList.get(i).getName());
        }
        mCreatorAssignedAdapter = new CreatorAssignedAdapter(volunteerList);
        mRecyclerView.setAdapter(mCreatorAssignedAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
