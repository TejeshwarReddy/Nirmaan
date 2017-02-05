package bphc.com.nirmaan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import bphc.com.nirmaan.R;
import bphc.com.nirmaan.object.StuMcq;
import io.realm.RealmResults;

/**
 * Created by sarath on 05-02-2017.
 */

public class StuMcqAdapter extends RecyclerView.Adapter<StuMcqAdapter.StuMcqViewHolder> {

    private RealmResults<StuMcq> mcqList;
    private Context context;

    public StuMcqAdapter(Context context, RealmResults<StuMcq> mcqList) {
        this.context = context;
        this.mcqList = mcqList;
    }

    class StuMcqViewHolder extends RecyclerView.ViewHolder {
        TextView question;
        TextView q_no;

        RadioGroup radioGroup;
        RadioButton r1, r2, r3, r4;

        StuMcqViewHolder(View itemView) {
            super(itemView);
            q_no = (TextView) itemView.findViewById(R.id.stu_mcq_q_no);
            question = (TextView) itemView.findViewById(R.id.stu_mcq_q_text);
            radioGroup = (RadioGroup) itemView.findViewById(R.id.stu_mcq_q_radiogroup);
            r1 = (RadioButton) itemView.findViewById(R.id.stu_mcq_opt1);
            r2 = (RadioButton) itemView.findViewById(R.id.stu_mcq_opt2);
            r3 = (RadioButton) itemView.findViewById(R.id.stu_mcq_opt3);
            r4 = (RadioButton) itemView.findViewById(R.id.stu_mcq_opt4);
        }

    }

    @Override
    public StuMcqAdapter.StuMcqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_stu_mcq_card, parent, false);
        return new StuMcqAdapter.StuMcqViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StuMcqAdapter.StuMcqViewHolder holder, int position) {
        //RadioGroup radioGroup = holder.radioGroup;
        //radioGroup.removeAllViews();

        StuMcq mcq = mcqList.get(position);

        holder.q_no.setText(position);
        holder.question.setText(mcq.getQuestion());
        holder.r1.setText(mcq.getA());
        holder.r2.setText(mcq.getB());
        holder.r3.setText(mcq.getC());
        holder.r4.setText(mcq.getD());

/*
        //setting the answer:
        switch (mcq.getAns()) {
            case "A":
                holder.r1.setChecked(true);
                break;
            case "B":
                holder.r2.setChecked(true);
                break;
            case "C":
                holder.r3.setChecked(true);
                break;
            case "D":
                holder.r4.setChecked(true);
                break;
        }
*/

    }


    @Override
    public int getItemCount() {
        return mcqList.size();
    }
}
