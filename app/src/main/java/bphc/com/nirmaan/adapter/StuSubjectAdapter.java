package bphc.com.nirmaan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bphc.com.nirmaan.R;
import bphc.com.nirmaan.object.StuMaterial;

/**
 * Created by siddhant on 2/5/17.
 */

public class StuSubjectAdapter
        extends RecyclerView.Adapter<StuSubjectAdapter.StuSubjectViewHolder> {

    private List<StuMaterial> mSubjects;
    private StuSubjectClickListener mClickListener;

    public StuSubjectAdapter(List<StuMaterial> subjects, StuSubjectClickListener clickListener) {
        mSubjects = subjects;
        mClickListener = clickListener;
    }

    public interface StuSubjectClickListener {
        void onClick(StuMaterial material);
    }

    public void setSubjects(List<StuMaterial> subjects) {
        mSubjects = subjects;
        notifyDataSetChanged();
    }

    @Override
    public StuSubjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new StuSubjectViewHolder(
                inflater.inflate(R.layout.custom_student_subject, parent, false));
    }

    @Override
    public void onBindViewHolder(StuSubjectViewHolder holder, int position) {
        holder.bind(mSubjects.get(position));
    }

    @Override
    public int getItemCount() {
        return mSubjects.size();
    }

    public final class StuSubjectViewHolder extends RecyclerView.ViewHolder {

        private TextView mSubject;

        public StuSubjectViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getLayoutPosition();
                    mClickListener.onClick(mSubjects.get(position));
                }
            });
            mSubject = (TextView) itemView.findViewById(R.id.name);
        }

        public void bind(StuMaterial subject) {
            mSubject.setText(subject.getSubject());
        }
    }
}
