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
public class FIBFragment extends Fragment {


    public FIBFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fib, container, false);
    }

    RecyclerView fibrecycler;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        fibrecycler = (RecyclerView) view.findViewById(R.id.fib_recycler_bank);
    }
}
