package bphc.com.nirmaan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import bphc.com.nirmaan.R;
import bphc.com.nirmaan.object.StuBlank;
import io.realm.RealmResults;

/**
 * Created by sarath on 05-02-2017.
 */

public class StuBlankAdapter extends RecyclerView.Adapter<StuBlankAdapter.StuBlankViewHolder> {

    private RealmResults<StuBlank> blankList;
    private Context context;

    public StuBlankAdapter(Context context, RealmResults<StuBlank> blankList) {
        this.context = context;
        this.blankList = blankList;
    }

    class StuBlankViewHolder extends RecyclerView.ViewHolder {
        TextView question, q_no;
        EditText ans;
        LinearLayout answersLinearLayoutContainer;
        ImageView correct, wrong;
        Button submit;

        StuBlankViewHolder(View itemView) {
            super(itemView);
            q_no = (TextView) itemView.findViewById(R.id.stu_blank_q_no);
            question = (TextView) itemView.findViewById(R.id.stu_blank_q_text);
            ans = (EditText) itemView.findViewById(R.id.stu_blank_ans);
            answersLinearLayoutContainer = (LinearLayout) itemView.findViewById(R.id.fib_answers_linearLayout_container);
            correct = (ImageView) itemView.findViewById(R.id.stu_blank_correct);
            wrong = (ImageView) itemView.findViewById(R.id.stu_blank_wrong);
            submit = (Button) itemView.findViewById(R.id.stu_blank_submit);
        }

    }

    @Override
    public StuBlankAdapter.StuBlankViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_stu_blank_card, parent, false);
        return new StuBlankAdapter.StuBlankViewHolder(itemView);
    }


    // answersLinearLayoutContainer is the ultimate container where views like:
    // answersContainer (a horizontal lin lay) which in turn contains two views:
    // 1) Answer number (TextView) and 2) Answer Blank (anotherTextView) (for Volunteer).
    @Override
    public void onBindViewHolder(final StuBlankAdapter.StuBlankViewHolder holder, int position) {
        //LinearLayout answersLinearLayoutContainer = holder.answersLinearLayoutContainer;
        //answersLinearLayoutContainer.removeAllViews();

        final StuBlank blank = blankList.get(position);
        holder.q_no.setText(position);
        holder.question.setText(blank.getQuestion());

        //to display the submit button:
        holder.ans.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(view.hasFocus()){
                    holder.submit.setVisibility(View.VISIBLE);
                }
            }
        });
        holder.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.ans.getText().toString().equals(blank.getAns())){
                    holder.correct.setVisibility(View.VISIBLE);
                }
                else{

                    holder.wrong.setVisibility(View.VISIBLE);
                }
                holder.submit.setVisibility(View.GONE);
            }
        });
        //holder.ans.setText(blank.getAns());
    }



    @Override
    public int getItemCount() {
        return blankList.size();
    }
}

