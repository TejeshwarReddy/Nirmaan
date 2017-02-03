package bphc.com.nirmaan;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.VolSchedule;


public class VolScheduleFragment extends Fragment {


    private LinearLayout mTutClassContainer;

    private DBTransactions mTransactions;

    public VolScheduleFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTransactions = new DBTransactions(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vol_schedule, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTutClassContainer = (LinearLayout) view.findViewById(R.id.vol_schedule_container);

        LayoutInflater inflater = LayoutInflater.from(view.getContext());
        List<VolSchedule> schedules = mTransactions.getSchedule();

        for (VolSchedule schedule : schedules){
            View scheduleView = inflater.inflate(R.layout.vol_schedule_row, mTutClassContainer);

            TextView date = (TextView) view.findViewById(R.id.vol_schedule_date);
            date.setText(schedule.getDate());

            TextView time_day = (TextView) view.findViewById(R.id.vol_schedule_accept);
            time_day.setText(schedule.getTime() + ", " + schedule.getDay());

            ImageView detail = (ImageView) view.findViewById(R.id.vol_schedule_detail);
            detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO: Complete the intent
                    Intent intent = new Intent();
                    startActivity(intent);
                }
            });
        }
    }



}
