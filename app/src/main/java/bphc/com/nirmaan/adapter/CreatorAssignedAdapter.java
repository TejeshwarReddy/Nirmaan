package bphc.com.nirmaan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bphc.com.nirmaan.R;
import bphc.com.nirmaan.object.Visit;
import bphc.com.nirmaan.object.Volunteer;

/**
 * Created by skrpl on 3/11/17.
 */

public class CreatorAssignedAdapter extends
        RecyclerView.Adapter<CreatorAssignedAdapter.CreatorAssignedViewHolder> {

    private List<Volunteer> mVolunteerList;
    private int[] ary;
    private int totalSchedules;

    public CreatorAssignedAdapter(List<Volunteer> volunteers) {
        mVolunteerList = volunteers;
        ary = new int[mVolunteerList.size()];
        for (int i = 0; i < mVolunteerList.size(); i++) {
            Volunteer volunteer = mVolunteerList.get(i);
            totalSchedules += volunteer.getVisits().size();
            ary[i] = totalSchedules;
        }
    }

    private int binarySearch(int[] ary, int n) {
        int left = 0;
        int right = ary.length;
        int mid;
        int ans = -1;

        while(right >= left) {
            mid = left + (right - left + 1)/2;
            if(ary[mid] >= n) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    @Override
    public CreatorAssignedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_creator_assigned_card, parent, false);
        return new CreatorAssignedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CreatorAssignedViewHolder holder, int position) {
        int volIndex = binarySearch(ary, position);
        int assignedScheduleIndex = ary[volIndex] - ary[volIndex-1] - 1;
        Volunteer volunteer = mVolunteerList.get(volIndex);
        Visit visit = volunteer.getVisits().get(assignedScheduleIndex);
        holder.bind(volunteer, visit);
    }

    @Override
    public int getItemCount() {
        return totalSchedules;
    }

    class CreatorAssignedViewHolder extends RecyclerView.ViewHolder {

        private TextView assignedVolName;
        private TextView assignedStatus;
        private TextView assignedClass;
        private TextView assignedSubject;
        private TextView assignedTopicId;
        private TextView assignedSchedule;

        public CreatorAssignedViewHolder(View itemView) {
            super(itemView);
            assignedVolName = (TextView) itemView.findViewById(R.id.assigned_vol_name);
            assignedStatus = (TextView) itemView.findViewById(R.id.assigned_status);
            assignedClass = (TextView) itemView.findViewById(R.id.assigned_class);
            assignedSubject = (TextView) itemView.findViewById(R.id.assigned_subject);
            assignedTopicId = (TextView) itemView.findViewById(R.id.assigned_topic_id);
            assignedSchedule = (TextView) itemView.findViewById(R.id.assigned_schedule);
        }

        public void bind(Volunteer volunteer, Visit visit) {
            assignedVolName.setText(volunteer.getName());
            assignedStatus.setText(visit.getDecision());
            assignedClass.setText(visit.getClass_());
            assignedSubject.setText(visit.getSubject());
            assignedTopicId.setText(visit.getTopicId());
            assignedSchedule.setText(String.valueOf(visit.getScheduledVisit()));
        }
    }
}
