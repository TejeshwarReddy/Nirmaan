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
        TextView question, correctAns;
        TextView q_no;

        ImageView correct, wrong;
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

            correctAns = (TextView) itemView.findViewById(R.id.stu_mcq_correct_answer);
            correct = (ImageView) itemView.findViewById(R.id.stu_mcq_correct);
            wrong = (ImageView) itemView.findViewById(R.id.stu_mcq_wrong);
        }

    }

    @Override
    public StuMcqAdapter.StuMcqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_stu_mcq_card, parent, false);
        return new StuMcqAdapter.StuMcqViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final StuMcqAdapter.StuMcqViewHolder holder, int position) {
        final StuMcq mcq = mcqList.get(position);

        //holder.q_no.setText(position);
        holder.question.setText(mcq.getQuestion());
        holder.r1.setText(mcq.getA());
        holder.r2.setText(mcq.getB());
        holder.r3.setText(mcq.getC());
        holder.r4.setText(mcq.getD());

        final DBTransactions dbTransactions = new DBTransactions(context);
        // StuAnswerListener is the class whose object will be used to compare if the question
        // is answered before. last parameter--> 0-blanks; 1-Mcq, 2-TF;
        RealmResults<StuAnswerListener> listenerSet = dbTransactions.getStudentAnswer(mcq.getSubject(),
                Integer.parseInt(mcq.getTopicId()),Integer.parseInt(mcq.getId()),1);

        if(listenerSet.size()==0){
            holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    int radioButtonID = radioGroup.getCheckedRadioButtonId();
                    switch (radioButtonID){
                        case R.id.stu_mcq_opt1:
                            if(mcq.getAns().equals("A")){
                                dbTransactions.feedStudentAnswer("A",
                                        mcq.getSubject(),
                                        1,
                                        Integer.parseInt(mcq.getTopicId()),
                                        Integer.parseInt(mcq.getId()),
                                        1);
                                holder.correct.setVisibility(View.VISIBLE);
                            }
                            else {
                                dbTransactions.feedStudentAnswer("A",
                                        mcq.getSubject(),
                                        1,
                                        Integer.parseInt(mcq.getTopicId()),
                                        Integer.parseInt(mcq.getId()),
                                        0);
                                holder.wrong.setVisibility(View.VISIBLE);
                                holder.correctAns.setText("Correct option is: "+ mcq.getAns());
                            }
                            break;
                        case R.id.stu_mcq_opt2:
                            if(mcq.getAns().equals("B")){
                                dbTransactions.feedStudentAnswer("B",
                                        mcq.getSubject(),
                                        1,
                                        Integer.parseInt(mcq.getTopicId()),
                                        Integer.parseInt(mcq.getId()),
                                        1);
                                holder.correct.setVisibility(View.VISIBLE);
                            }
                            else {
                                dbTransactions.feedStudentAnswer("B",
                                        mcq.getSubject(),
                                        1,
                                        Integer.parseInt(mcq.getTopicId()),
                                        Integer.parseInt(mcq.getId()),
                                        0);
                                holder.wrong.setVisibility(View.VISIBLE);
                                holder.correctAns.setText("Correct option is: "+ mcq.getAns());
                            }
                            break;
                        case R.id.stu_mcq_opt3:
                            if(mcq.getAns().equals("C")){
                                dbTransactions.feedStudentAnswer("C",
                                        mcq.getSubject(),
                                        1,
                                        Integer.parseInt(mcq.getTopicId()),
                                        Integer.parseInt(mcq.getId()),
                                        1);
                                holder.correct.setVisibility(View.VISIBLE);
                            }
                            else {
                                dbTransactions.feedStudentAnswer("C",
                                        mcq.getSubject(),
                                        1,
                                        Integer.parseInt(mcq.getTopicId()),
                                        Integer.parseInt(mcq.getId()),
                                        0);
                                holder.wrong.setVisibility(View.VISIBLE);
                                holder.correctAns.setText("Correct option is: "+ mcq.getAns());
                            }
                            break;
                        case R.id.stu_mcq_opt4:
                            if(mcq.getAns().equals("D")){
                                dbTransactions.feedStudentAnswer("D",
                                        mcq.getSubject(),
                                        1,
                                        Integer.parseInt(mcq.getTopicId()),
                                        Integer.parseInt(mcq.getId()),
                                        1);
                                holder.correct.setVisibility(View.VISIBLE);
                            }
                            else {
                                dbTransactions.feedStudentAnswer("D",
                                        mcq.getSubject(),
                                        1,
                                        Integer.parseInt(mcq.getTopicId()),
                                        Integer.parseInt(mcq.getId()),
                                        0);
                                holder.wrong.setVisibility(View.VISIBLE);
                                holder.correctAns.setText("Correct option is: "+ mcq.getAns());
                            }
                    }
                }
            });
        }
        else { // If the listenerSet.size()!=0 ==> Question was answered before
            StuAnswerListener listener = listenerSet.get(0);
            if(listener.getIsRight()==0){
                String stuAns = listener.getAnswer();
                switch (stuAns){
                    case "A":
                        holder.r1.setChecked(true);
                        holder.correct.setVisibility(View.VISIBLE);
                        break;
                    case "B":
                        holder.r2.setChecked(true);
                        holder.correct.setVisibility(View.VISIBLE);
                        break;
                    case "C":
                        holder.r3.setChecked(true);
                        holder.correct.setVisibility(View.VISIBLE);
                        break;
                    case "D":
                        holder.r4.setChecked(true);
                        holder.correct.setVisibility(View.VISIBLE);
                }
            }
            else { // if student answered wrong
                String stuAns = listener.getAnswer();
                switch (stuAns){
                    case "A":
                        holder.r1.setChecked(true);
                        holder.wrong.setVisibility(View.VISIBLE);
                        holder.correctAns.setText("The correct answer is option: "+ mcq.getAns());
                        holder.correctAns.setVisibility(View.VISIBLE);
                        break;
                    case "B":
                        holder.r2.setChecked(true);
                        holder.wrong.setVisibility(View.VISIBLE);
                        holder.correctAns.setText("The correct answer is option: "+ mcq.getAns());
                        holder.correctAns.setVisibility(View.VISIBLE);
                        break;
                    case "C":
                        holder.r3.setChecked(true);
                        holder.wrong.setVisibility(View.VISIBLE);
                        holder.correctAns.setText("The correct answer is option: "+ mcq.getAns());
                        holder.correctAns.setVisibility(View.VISIBLE);
                        break;
                    case "D":
                        holder.r4.setChecked(true);
                        holder.wrong.setVisibility(View.VISIBLE);
                        holder.correctAns.setText("The correct answer is option: "+ mcq.getAns());
                        holder.correctAns.setVisibility(View.VISIBLE);
                }
            }
        }
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