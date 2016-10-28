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

public class McqRecyclerAdapter extends RecyclerView.Adapter<McqRecyclerAdapter.McqViewHolder> {

    private List<Mcq> mcqList;
    Context context;


    public class McqViewHolder extends RecyclerView.ViewHolder {
        public TextView question, answer;
        RadioGroup radioGroup;


        public McqViewHolder(View itemView) {
            super(itemView);

            question = (TextView) itemView.findViewById(R.id.McqQuestion);
            answer = (TextView) itemView.findViewById(R.id.McqAnswer);
            radioGroup=(RadioGroup) itemView.findViewById(R.id.RadioGroup);
        }
    }

    public McqRecyclerAdapter(Context context, List<Mcq> mcqList) {
        this.context = context;
        this.mcqList = mcqList;
    }

    @Override
    public McqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mcq_rec_view, parent, false);
        return new McqViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(McqViewHolder holder, int position) {
        RadioGroup radioGroup = holder.radioGroup;
        radioGroup.removeAllViews();

        Mcq mcq = mcqList.get(position);
        RadioGroup.LayoutParams rprms;

        for (int j = 0; j < mcq.getOptions().size(); j++) {
            RadioButton radioButton = new RadioButton(context);

            rprms= new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rprms.gravity= Gravity.CENTER;

            radioButton.setLayoutParams(rprms);
            radioButton.setTextColor(Color.parseColor("#565050"));
            radioButton.setText(mcq.getOptions().get(j));


            holder.radioGroup.addView(radioButton);

        }
        holder.question.setText("Q" + position + ") " +mcq.getQuestion());
        holder.answer.setText("Answer) " + mcq.getAnswer());
    }



    @Override
    public int getItemCount() {
        return mcqList.size();
    }
}
