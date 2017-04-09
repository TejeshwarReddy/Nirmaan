package bphc.com.nirmaan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bphc.com.nirmaan.adapter.StuTopicAdapter;
import bphc.com.nirmaan.app.Constants;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.StuTopicCount;

/**
 * Created by siddhant on 2/5/17.
 */

public class StuTopicFragment extends DialogFragment
        implements StuTopicAdapter.OnStuTopicClickListener{

    private static final String SUBJECT_KEY = "subject";

    private RecyclerView mTopicContainer;
    private String mSubject;

    public static StuTopicFragment newInstance(String subject) {
        Bundle args = new Bundle();
        args.putString(SUBJECT_KEY, subject);
        StuTopicFragment fragment = new StuTopicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null || args.size() > 0) {
            mSubject = args.getString(SUBJECT_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stu_topic, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        System.out.println("Inside topic frag onViewCreated");
        mTopicContainer = (RecyclerView) view.findViewById(R.id.stu_topic_container);
        List<StuTopicCount> topics = new DBTransactions(getActivity()).getTopics(mSubject);
        StuTopicAdapter adapter = new StuTopicAdapter(topics, this);
        mTopicContainer.setAdapter(adapter);
        mTopicContainer.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onClick(StuTopicCount topic) {
        dismiss();
        Intent intent = new Intent(getActivity(), StuQuestionBankActivity.class);
        intent.putExtra(Constants.KEY_STUDENT_SUBJECT, topic.getSubject());
        intent.putExtra(Constants.KEY_STUDENT_TOPIC_ID, topic.getTopics());
        startActivity(intent);
    }
}
