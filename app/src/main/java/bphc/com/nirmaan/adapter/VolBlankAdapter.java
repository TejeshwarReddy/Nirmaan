package bphc.com.nirmaan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import bphc.com.nirmaan.R;
import bphc.com.nirmaan.object.VolBlank;
import io.realm.RealmResults;

public class VolBlankAdapter extends RecyclerView.Adapter<VolBlankAdapter.FibViewHolder> {

    private RealmResults<VolBlank> blankList;
    private Context context;

    public VolBlankAdapter(Context context, RealmResults<VolBlank> blankList) {
        this.context = context;
        this.blankList = blankList;
    }

    class FibViewHolder extends RecyclerView.ViewHolder {
        TextView question, q_no, ans;
        LinearLayout answersLinearLayoutContainer;

        FibViewHolder(View itemView) {
            super(itemView);
            q_no = (TextView) itemView.findViewById(R.id.vol_blank_q_no);
            question = (TextView) itemView.findViewById(R.id.vol_blank_q_text);
            ans = (TextView) itemView.findViewById(R.id.vol_blank_ans);
            answersLinearLayoutContainer = (LinearLayout) itemView.findViewById(R.id.fib_answers_linearLayout_container);
        }

    }

    @Override
    public FibViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_vol_blank_card, parent, false);
        return new FibViewHolder(itemView);
    }


    // answersLinearLayoutContainer is the ultimate container where views like:
    // answersContainer (a horizontal lin lay) which in turn contains two views:
    // 1) Answer number (TextView) and 2) Answer StuBlank (anotherTextView) (for Volunteer).
    @Override
    public void onBindViewHolder(FibViewHolder holder, int position) {
        //LinearLayout answersLinearLayoutContainer = holder.answersLinearLayoutContainer;
        //answersLinearLayoutContainer.removeAllViews();

        VolBlank blank = blankList.get(position);
        holder.q_no.setText(blank.getId());
        holder.question.setText(blank.getQuestion());
        holder.ans.setText(blank.getAns());
    }



    @Override
    public int getItemCount() {
        return blankList.size();
    }
}

