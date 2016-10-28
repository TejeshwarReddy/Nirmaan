package bphc.com.nirmaan.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import bphc.com.nirmaan.R;
import bphc.com.nirmaan.model.Mcq;

public class McqAdapter extends RecyclerView.Adapter<McqAdapter.McqViewHolder> {

    private List<Mcq> mcqList;
    private Context context;

    public McqAdapter(Context context, List<Mcq> mcqList) {
        this.context = context;
        this.mcqList = mcqList;
    }

    class McqViewHolder extends RecyclerView.ViewHolder {
        TextView question;
        TextView answer;


        RadioGroup radioGroup;
        McqViewHolder(View itemView) {
            super(itemView);
            question = (TextView) itemView.findViewById(R.id.McqQuestion);
            answer = (TextView) itemView.findViewById(R.id.McqAnswer);
            radioGroup=(RadioGroup) itemView.findViewById(R.id.RadioGroup);
        }

    }

    @Override
    public McqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mcq_rec_view, parent, false);
        return new McqViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(McqViewHolder holder, int position) {
        RadioGroup radioGroup = holder.radioGroup;
        radioGroup.removeAllViews();

        Mcq mcq = mcqList.get(position);
        RadioGroup.LayoutParams radioGroupLayoutParams;

        for (int j = 0; j < mcq.getOptions().length; j++) {
            RadioButton radioButton = new RadioButton(context);
            if (j == mcq.getAnswer())
                radioButton.setChecked(true);
            radioButton.setClickable(false);

            radioGroupLayoutParams= new RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.MATCH_PARENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
            );
            radioGroupLayoutParams.gravity = Gravity.CENTER;
            radioButton.setLayoutParams(radioGroupLayoutParams);
            radioButton.setTextColor(Color.parseColor("#565050")); // needs to be changed later
            radioButton.setText(mcq.getOptions()[j]);
            radioGroup.addView(radioButton);
        }

        // needs to be changed later
        holder.question.setText("Q" + position + ") " +mcq.getQuestion());
        holder.answer.setText("Answer) " + mcq.getAnswer());
    }



    @Override
    public int getItemCount() {
        return mcqList.size();
    }
}
