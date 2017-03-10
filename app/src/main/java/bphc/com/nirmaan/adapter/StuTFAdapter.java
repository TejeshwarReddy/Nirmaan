package bphc.com.nirmaan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import bphc.com.nirmaan.R;
import bphc.com.nirmaan.database.DBTransactions;
import bphc.com.nirmaan.object.StuAnswerListener;
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
        TextView question,q_no, correctAns;
        RadioGroup radioGroup;
        RadioButton r1, r2;

        ImageView correct, wrong;

        StuTFViewHolder(View itemView) {
            super(itemView);
            q_no = (TextView) itemView.findViewById(R.id.stu_tf_q_no);
            question = (TextView) itemView.findViewById(R.id.stu_tf_q_text);
            radioGroup=(RadioGroup) itemView.findViewById(R.id.stu_tf_q_radiogroup);
            r1=(RadioButton) itemView.findViewById(R.id.stu_tf_r1);
            r2=(RadioButton) itemView.findViewById(R.id.stu_tf_r2);

            correctAns = (TextView) itemView.findViewById(R.id.stu_tf_correct_answer);
            correct = (ImageView) itemView.findViewById(R.id.stu_tf_correct);
            wrong = (ImageView) itemView.findViewById(R.id.stu_tf_wrong);
        }

    }

    @Override
    public StuTFAdapter.StuTFViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_stu_tf_card, parent, false);
        return new StuTFAdapter.StuTFViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final StuTFAdapter.StuTFViewHolder holder, int position) {
        RadioGroup radioGroup = holder.radioGroup;
        //radioGroup.removeAllViews();

        final StuTruefalse tf = tfList.get(position);
//        holder.q_no.setText(tf.getId());
        holder.question.setText(tf.getQuestion());


        final DBTransactions dbTransactions = new DBTransactions(context);
        // StuAnswerListener is the class whose object will be used to compare if the question
        // is answered before. last parameter--> 0-blanks; 1-Mcq, 2-TF;
        RealmResults<StuAnswerListener> listenerSet = dbTransactions.getStudentAnswer(tf.getSubject(),
                Integer.parseInt(tf.getTopicId()),Integer.parseInt(tf.getId()),2);

        if(listenerSet==null){
            holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    int radioButtonID = radioGroup.getCheckedRadioButtonId();
                    switch (radioButtonID){
                        case R.id.stu_tf_r1:    // If the true is selected;
                            if(Integer.parseInt(tf.getAns())==1){
                                dbTransactions.feedStudentAnswer("1",
                                        tf.getSubject(),
                                        2,
                                        Integer.parseInt(tf.getTopicId()),
                                        Integer.parseInt(tf.getId()),
                                        1);
                                holder.correct.setVisibility(View.VISIBLE);
                            }
                            else {
                                dbTransactions.feedStudentAnswer("1",
                                        tf.getSubject(),
                                        2,
                                        Integer.parseInt(tf.getTopicId()),
                                        Integer.parseInt(tf.getId()),
                                        0);
                                holder.wrong.setVisibility(View.VISIBLE);
                                holder.correctAns.setText("Correct option is: False");
                            }
                            break;
                        case R.id.stu_mcq_opt2: // if student selected false
                            if(Integer.parseInt(tf.getAns())==0){ // if the answer is also false
                                dbTransactions.feedStudentAnswer("0",
                                        tf.getSubject(),
                                        2,
                                        Integer.parseInt(tf.getTopicId()),
                                        Integer.parseInt(tf.getId()),
                                        1);
                                holder.correct.setVisibility(View.VISIBLE);
                            }
                            else {
                                dbTransactions.feedStudentAnswer("0",
                                        tf.getSubject(),
                                        2,
                                        Integer.parseInt(tf.getTopicId()),
                                        Integer.parseInt(tf.getId()),
                                        0);
                                holder.wrong.setVisibility(View.VISIBLE);
                                holder.correctAns.setText("Correct option is: False");
                            }
                    }
                }
            });
        }
        else if(listenerSet.size()==1){
            StuAnswerListener listener = listenerSet.get(0);
            if(listener.getIsRight()==0){
                // if the student answered correctly
                String stuAns = listener.getAnswer();
                switch (stuAns){
                    case "1": // if the student answered true (which is correct)
                        holder.r1.setChecked(true);
                        holder.correct.setVisibility(View.VISIBLE);
                        break;
                    case "0": // if the student answered false (which is correct)
                        holder.r2.setChecked(true);
                        holder.correct.setVisibility(View.VISIBLE);
                }
            }
            else { // if student answered wrong
                String stuAns = listener.getAnswer();
                switch (stuAns){
                    case "1": // if the student answered true (which is wrong)
                        holder.r1.setChecked(true);
                        holder.wrong.setVisibility(View.VISIBLE);
                        break;
                    case "0":
                        holder.r2.setChecked(true);
                        holder.wrong.setVisibility(View.VISIBLE);
                }
            }
        }

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