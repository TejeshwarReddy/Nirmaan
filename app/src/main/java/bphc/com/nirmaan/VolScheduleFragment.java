package bphc.com.nirmaan;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import bphc.com.nirmaan.app.Constants;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.VolSchedule;


public class VolScheduleFragment extends Fragment {

    private LinearLayout mTutClassContainer;

    private GregorianCalendar mCalendar;

    private DBTransactions mTransactions;

    public VolScheduleFragment() {
    }

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
        mTutClassContainer = (LinearLayout) view.findViewById(R.id.vol_schedule_container);

        LayoutInflater inflater = LayoutInflater.from(view.getContext());
        List<VolSchedule> schedules = mTransactions.getVolSchedule();
        System.out.println("Size of schedule: " + schedules.size());

        for (final VolSchedule schedule : schedules){
            View scheduleView = inflater.inflate(R.layout.vol_schedule_row, mTutClassContainer, false);
            mCalendar.setTimeInMillis(schedule.getScheduledVisit());

            TextView date = (TextView) scheduleView.findViewById(R.id.vol_schedule_date);
            date.setText(getDate(mCalendar));

            TextView time_day = (TextView) scheduleView.findViewById(R.id.vol_schedule_time_day);
            time_day.setText(getTime(mCalendar) + ", " + getDay(mCalendar));

            ImageButton button = (ImageButton) scheduleView.findViewById(R.id.vol_schedule_detail);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final VolSchedule intentSchedule = schedule;
                    Intent intent = new Intent(getActivity(), QuestionBankActivity.class);
                    intent.putExtra(
                            Constants.KEY_VOLUNTEER_TIME, intentSchedule.getScheduledVisit());
                    startActivity(intent);
                }
            });
            scheduleView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final VolSchedule intentSchedule = schedule;
                    Intent intent = new Intent(getActivity(), QuestionBankActivity.class);
                    intent.putExtra(
                            Constants.KEY_VOLUNTEER_TIME, intentSchedule.getScheduledVisit());
                   startActivity(intent);
                }
            });
            mTutClassContainer.addView(scheduleView);
        }
    }

    /**
     * @return Date as String, pattern: 8 February, 1997
     */
    public String getDate(Calendar calendar) {
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        int year = calendar.get(Calendar.YEAR);
        return Integer.toString(dayOfMonth) + " " + month + ", " + Integer.toString(year);
    }

    /**
     * @return Day as String, pattern: Saturday
     */
    public String getDay(Calendar calendar) {
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
    }

    /**
     * @return Time as String, pattern: 9:15 AM
     */
    public String getTime(Calendar calendar) {

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        String amPm = calendar.getDisplayName(Calendar.AM_PM, Calendar.LONG, Locale.getDefault());
        return Integer.toString(hour) + ":" + Integer.toString(minute) + " " + amPm;
    }

}
