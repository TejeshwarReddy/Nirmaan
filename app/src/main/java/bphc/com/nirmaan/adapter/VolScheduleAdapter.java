package bphc.com.nirmaan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import bphc.com.nirmaan.R;
import bphc.com.nirmaan.object.VolSchedule;

/**
 * Created by siddhant on 2/5/17.
 */

public class VolScheduleAdapter
        extends RecyclerView.Adapter<VolScheduleAdapter.VolScheduleViewHolder>{

    private List<VolSchedule> mVolScheduleList;
    private VolScheduleClickListener mClickListener;
    private GregorianCalendar mCalendar;

    public VolScheduleAdapter (
            List<VolSchedule> scheduleList,
            VolScheduleClickListener clickListener) {
        mVolScheduleList = scheduleList;
        mClickListener = clickListener;
        mCalendar = new GregorianCalendar();
    }

    @Override
    public VolScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new VolScheduleViewHolder(
                inflater.inflate(R.layout.vol_schedule_row, parent, false));
    }

    @Override
    public void onBindViewHolder(VolScheduleViewHolder holder, int position) {
        holder.bind(mVolScheduleList.get(position));
    }

    @Override
    public int getItemCount() {
        return mVolScheduleList.size();
    }

    public interface VolScheduleClickListener {
        void onClick(Long scheduleVisit);
    }

    public final class VolScheduleViewHolder extends RecyclerView.ViewHolder {

        private TextView mVolScheduleDate;
        private TextView mVolScheduleTimeDay;
        private ImageView mVolScheduleDetail;

        public VolScheduleViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getLayoutPosition();
                    mClickListener.onClick(mVolScheduleList.get(position).getScheduledVisit());
                }
            });

            mVolScheduleDate = (TextView) itemView.findViewById(R.id.vol_schedule_date);
            mVolScheduleTimeDay = (TextView) itemView.findViewById(R.id.vol_schedule_time_day);
            mVolScheduleDetail = (ImageView) itemView.findViewById(R.id.vol_schedule_detail);
        }

        public void bind(VolSchedule schedule) {
            mCalendar.setTimeInMillis(schedule.getScheduledVisit());
            mVolScheduleDate.setText(getDate(mCalendar));
            mVolScheduleTimeDay.setText(getTime(mCalendar) + ", " + getDay(mCalendar));
        }

        /**
         * @return Date as String, pattern: 8 February, 1997
         */
        public String getDate(Calendar calendar) {
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
            String month = calendar.getDisplayName(
                    Calendar.MONTH, Calendar.LONG, Locale.getDefault());
            int year = calendar.get(Calendar.YEAR);
            return Integer.toString(dayOfMonth) + " " + month + ", " + Integer.toString(year);
        }

        /**
         * @return Day as String, pattern: Saturday
         */
        public String getDay(Calendar calendar) {
            return calendar.getDisplayName(
                    Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
        }

        /**
         * @return Time as String, pattern: 9:15 AM
         */
        public String getTime(Calendar calendar) {

            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            String amPm = calendar.getDisplayName(
                    Calendar.AM_PM, Calendar.LONG, Locale.getDefault());
            return Integer.toString(hour) + ":" + Integer.toString(minute) + " " + amPm;
        }
    }
}
