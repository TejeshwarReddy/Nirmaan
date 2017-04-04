package bphc.com.nirmaan.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bphc.com.nirmaan.R;
import bphc.com.nirmaan.object.StuTopicCount;

/**
 * Created by siddhant on 2/5/17.
 */

public class StuTopicAdapter extends RecyclerView.Adapter<StuTopicAdapter.StuChapterViewHolder> {

    private List<StuTopicCount> mTopicList;
    private OnStuTopicClickListener mClickListener;

    public StuTopicAdapter(List<StuTopicCount> topics, OnStuTopicClickListener clickListener) {
        mTopicList = topics;
        mClickListener = clickListener;
    }

    public interface OnStuTopicClickListener {
        void onClick(StuTopicCount topic);
    }

    @Override
    public StuChapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new StuChapterViewHolder(
                inflater.inflate(R.layout.custom_student_topic_row, parent, false));
    }

    @Override
    public void onBindViewHolder(StuChapterViewHolder holder, int position) {
        holder.bind(mTopicList.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public final class StuChapterViewHolder extends RecyclerView.ViewHolder {

        private TextView mTopicName;

        public StuChapterViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getLayoutPosition();
                    mClickListener.onClick(mTopicList.get(position));
                }
            });
            mTopicName = (TextView) itemView.findViewById(R.id.name);
        }

        public void bind(StuTopicCount topic) {
            mTopicName.setText(topic.getTopics());
        }
    }
}
