package bphc.com.nirmaan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        String timeDay = tutorialClass.getTime() + ", " + tutorialClass.getDay();

        holder.tutorialDate.setText(date);
        holder.tutorialTimeDay.setText(timeDay);
    }

    @Override
    public int getItemCount() {
        return tutorialClasses.length;
    }

    class TutorialClassViewHolder extends RecyclerView.ViewHolder {

        TextView tutorialDate;
        TextView tutorialTimeDay;
        ImageView tutorialDetails;

        TutorialClassViewHolder(View itemView) {
            super(itemView);
            tutorialDate = (TextView) itemView.findViewById(R.id.tut_class_date);
            tutorialTimeDay = (TextView) itemView.findViewById(R.id.tut_class_time_day);

            tutorialDetails = (ImageView) itemView.findViewById(R.id.tut_class_detail);
            tutorialDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO: Complete explicit intent for details view having study materials & questions
                }
            });
        }
    }
}
