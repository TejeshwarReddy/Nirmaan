package bphc.com.nirmaan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by sarath on 30-10-2016.
 */

public class Fib_Adapter extends RecyclerView.Adapter<Fib_Adapter.FibViewHolder> {

    Context context;
    List fibList;

    public Fib_Adapter(Context context, List fibList) {
        this.context = context;
        this.fibList = fibList;
    }

    @Override
    public FibViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(FibViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return fibList.size();
    }

    public class FibViewHolder extends RecyclerView.ViewHolder{

        public FibViewHolder(View itemView) {
            super(itemView);
        }
    }

}
