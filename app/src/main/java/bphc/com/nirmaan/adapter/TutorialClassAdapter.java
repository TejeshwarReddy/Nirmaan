package bphc.com.nirmaan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import bphc.com.nirmaan.R;
import bphc.com.nirmaan.object.TutorialClass;


public class TutorialClassAdapter extends
        RecyclerView.Adapter<TutorialClassAdapter.TutorialClassViewHolder> {

    private LayoutInflater inflater;
    private TutorialClass[] tutorialClasses;

    public TutorialClassAdapter(Context context, TutorialClass[] tutorialClasses) {
        inflater = LayoutInflater.from(context);
        this.tutorialClasses = tutorialClasses;
    }

    @Override
    public TutorialClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tut_class_row, parent, false);
        return new TutorialClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TutorialClassViewHolder holder, int position) {
        TutorialClass tutorialClass = tutorialClasses[position];

        String date = tutorialClass.getDate();
        String dayTime = tutorialClass.getDay() + ", " + tutorialClass.getTime();
        String classSubject = Integer.toString(tutorialClass.getStandard()) +
                ", " + tutorialClass.getSubject();
        String topic = tutorialClass.getTopic();

        holder.tutorialDate.setText(date);
        holder.tutorialDayTime.setText(dayTime);
        holder.tutorialClassSubject.setText(classSubject);
        holder.tutorialTopic.setText(topic);
    }

    @Override
    public int getItemCount() {
        return tutorialClasses.length;
    }

    class TutorialClassViewHolder extends RecyclerView.ViewHolder {

        TextView tutorialDate;
        TextView tutorialDayTime;
        TextView tutorialClassSubject;
        TextView tutorialTopic;

        TutorialClassViewHolder(View itemView) {
            super(itemView);
            tutorialDate = (TextView) itemView.findViewById(R.id.tutorial_date);
            tutorialDayTime = (TextView) itemView.findViewById(R.id.tutorial_day_time);
            tutorialClassSubject = (TextView) itemView.findViewById(R.id.tutorial_class_subject);
            tutorialTopic = (TextView) itemView.findViewById(R.id.tutorial_topic);
        }
    }
}
