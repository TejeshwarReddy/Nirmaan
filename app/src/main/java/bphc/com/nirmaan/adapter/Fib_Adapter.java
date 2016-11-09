package bphc.com.nirmaan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import bphc.com.nirmaan.R;
import bphc.com.nirmaan.model.Fib;
import bphc.com.nirmaan.model.Mcq;

public class Fib_Adapter extends RecyclerView.Adapter<Fib_Adapter.FibViewHolder> {

    private List<Fib> fibList;
    private Context context;

    public Fib_Adapter(Context context, List<Fib> fibList) {
        this.context = context;
        this.fibList = fibList;
    }

    class FibViewHolder extends RecyclerView.ViewHolder {
        TextView question;
        LinearLayout answersLinearLayoutContainer;

        FibViewHolder(View itemView) {
            super(itemView);
            question = (TextView) itemView.findViewById(R.id.fib_q_no);
            answersLinearLayoutContainer = (LinearLayout) itemView.findViewById(R.id.fib_answers_linearLayout_container);
        }

    }

    @Override
    public FibViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_fib_card, parent, false);
        return new FibViewHolder(itemView);
    }


    // answersLinearLayoutContainer is the ultimate container where views like:
    // answersContainer (a horizontal lin lay) which in turn contains two views:
    // 1) Answer number (TextView) and 2) Answer Blank (anotherTextView) (for Volunteer).
    @Override
    public void onBindViewHolder(FibViewHolder holder, int position) {
        LinearLayout answersLinearLayoutContainer = holder.answersLinearLayoutContainer;
        answersLinearLayoutContainer.removeAllViews();

        Fib fib = fibList.get(position);

        // For each answer in the array, we create a new linearlayout container and add the
        // corresponding answer views to the contatiner linear layout.
        for (int j = 0; j < fib.getAnswers().length; j++) {

            LinearLayout answersContainer = new LinearLayout(context);
            TextView answerNumber = new TextView(context);
            TextView answer = new TextView(context);

            LinearLayout.LayoutParams containerLayoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);


            ViewGroup.LayoutParams answerNumberLayoutParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );

            ViewGroup.LayoutParams answerLayoutParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );

            answerNumber.setLayoutParams(answerNumberLayoutParams);
            answerNumber.setTextSize(16);
            answer.setLayoutParams(answerLayoutParams);
            answer.setTextSize(16);

            answersContainer.setOrientation(LinearLayout.HORIZONTAL);
            containerLayoutParams.setMargins(0,0,0,0);
            answersContainer.setLayoutParams(containerLayoutParams);

            answerNumber.setText("Blank "+ (position + 1)+ ". ");
            answer.setText(fib.getQuestion());

            answersContainer.addView(answerNumber);
            answersContainer.addView(answer);

            answersLinearLayoutContainer.addView(answersContainer);
        }

    }



    @Override
    public int getItemCount() {
        return fibList.size();
    }
}
