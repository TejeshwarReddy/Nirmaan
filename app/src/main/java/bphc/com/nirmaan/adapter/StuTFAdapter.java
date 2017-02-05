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
import bphc.com.nirmaan.object.StuTruefalse;
import io.realm.RealmResults;

/**
 * Created by sarath on 05-02-2017.
 */

public class StuTFAdapter extends RecyclerView.Adapter<StuTFAdapter.StuTFViewHolder> {

private RealmResults<StuTruefalse> tfList;
private Context context;

public StuTFAdapter(Context context, RealmResults<StuTruefalse> tfList) {
        this.context = context;
        this.tfList = tfList;
        }

class StuTFViewHolder extends RecyclerView.ViewHolder {
    TextView question,q_no;
    RadioGroup radioGroup;
    RadioButton r1, r2;
    StuTFViewHolder(View itemView) {
        super(itemView);
        q_no = (TextView) itemView.findViewById(R.id.stu_tf_q_no);
        question = (TextView) itemView.findViewById(R.id.stu_tf_q_text);
        radioGroup=(RadioGroup) itemView.findViewById(R.id.stu_tf_q_radiogroup);
        r1=(RadioButton) itemView.findViewById(R.id.stu_tf_r1);
        r2=(RadioButton) itemView.findViewById(R.id.stu_tf_r2);
    }

}

    @Override
    public StuTFAdapter.StuTFViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_stu_mcq_card, parent, false);
        return new StuTFAdapter.StuTFViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StuTFAdapter.StuTFViewHolder holder, int position) {
        RadioGroup radioGroup = holder.radioGroup;
        radioGroup.removeAllViews();

        StuTruefalse tf = tfList.get(position);
        holder.q_no.setText(tf.getId());
        holder.question.setText(tf.getQuestion());

/*
        //For answer
        switch(tf.getAns()){
            case "1": holder.r1.setChecked(true);
                break;
            case "2": holder.r2.setChecked(true);
                break;

        }
*/

    }



    @Override
    public int getItemCount() {
        return tfList.size();
    }
}
