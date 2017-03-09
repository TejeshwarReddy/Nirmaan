package bphc.com.nirmaan;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.GregorianCalendar;
import java.util.List;

import bphc.com.nirmaan.adapter.VolScheduleAdapter;
import bphc.com.nirmaan.app.Constants;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.VolSchedule;


public class VolScheduleFragment extends Fragment
        implements VolScheduleAdapter.VolScheduleClickListener{

    private RecyclerView mVolScheduleContainer;

    private GregorianCalendar mCalendar;

    private DBTransactions mTransactions;
    private VolScheduleAdapter mAdapter;

    public VolScheduleFragment() {
    }

    //TODO: Implement a broadcast receiver so that when network request is complete, the view gets
    // populated automatically after closing progress dialog.

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTransactions = new DBTransactions(getActivity());
        mCalendar = new GregorianCalendar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vol_schedule, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mVolScheduleContainer = (RecyclerView) view.findViewById(R.id.vol_schedule_container);

        LayoutInflater inflater = LayoutInflater.from(view.getContext());
        List<VolSchedule> schedules = mTransactions.getVolSchedule();
        mAdapter = new VolScheduleAdapter(schedules, this);
        mVolScheduleContainer.setAdapter(mAdapter);
        mVolScheduleContainer.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void onClick(Long scheduleVisit) {
        Intent intent = new Intent(getActivity(), VolunteerQuestionBankActivity.class);
        intent.putExtra(
                Constants.KEY_VOLUNTEER_TIME, scheduleVisit);

        startActivity(intent);
    }
}
