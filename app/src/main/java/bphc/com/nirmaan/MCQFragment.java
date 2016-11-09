package bphc.com.nirmaan;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MCQFragment extends Fragment {


    public MCQFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mcq, container, false);
    }

    RecyclerView mcqrecycler;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mcqrecycler = (RecyclerView) view.findViewById(R.id.mcq_recycler_bank);
    }
}
