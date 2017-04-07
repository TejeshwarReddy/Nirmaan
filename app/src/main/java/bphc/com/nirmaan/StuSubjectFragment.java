package bphc.com.nirmaan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import bphc.com.nirmaan.adapter.StuSubjectAdapter;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.StuMaterial;

/**
 * Created by siddhant on 2/5/17.
 */

public class StuSubjectFragment extends Fragment implements
        StuSubjectAdapter.StuSubjectClickListener{

    private RecyclerView mRecyclerView;

    private List<StuMaterial> mSubjectMaterials;
    private StuSubjectAdapter mAdapter;
    private DBTransactions mTransactions;

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stu_subject, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mTransactions = new DBTransactions(getContext());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.stu_subject_container);

        mSubjectMaterials = mTransactions.getMaterial();
        mAdapter = new StuSubjectAdapter(mSubjectMaterials, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onClick(StuMaterial material) {
        StuTopicFragment fragment = StuTopicFragment.newInstance(material.getSubject());
        fragment.show(getActivity().getSupportFragmentManager(), null);
    }
}
