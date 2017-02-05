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
        TextView question, q_no, correctAns;
        EditText ans;
        LinearLayout answerDropDown;
        ImageView correct, wrong;
        Button submit;

        StuBlankViewHolder(View itemView) {
            super(itemView);
            q_no = (TextView) itemView.findViewById(R.id.stu_blank_q_no);
            question = (TextView) itemView.findViewById(R.id.stu_blank_q_text);
            ans = (EditText) itemView.findViewById(R.id.stu_blank_ans);
            correct = (ImageView) itemView.findViewById(R.id.stu_blank_correct);
            correctAns = (TextView) itemView.findViewById(R.id.stu_blank_correct_ans);
            wrong = (ImageView) itemView.findViewById(R.id.stu_blank_wrong);
            submit = (Button) itemView.findViewById(R.id.stu_blank_submit);
            answerDropDown= (LinearLayout) itemView.findViewById(R.id.stu_blank_drop_down_lin_layout);
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
                    holder.answerDropDown.setVisibility(View.VISIBLE);
                }
            }
        });
        holder.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.ans.getText().toString().equals(blank.getAns())){
                        // for right

                    // display correct image; diaplay drop-down
                    //
                    holder.correct.setVisibility(View.VISIBLE);
                }
                else{   // for wrong

                    // display wrong image; visible the drop-down;
                    // set correct answer in the text view.
                    // visible the correct answer.

                    holder.correctAns.setText("Correct answer is: "+ blank.getAns());
                    holder.wrong.setVisibility(View.VISIBLE);
                    holder.answerDropDown.setVisibility(View.VISIBLE);
                    holder.correctAns.setVisibility(View.VISIBLE);
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

