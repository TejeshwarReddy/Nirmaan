package bphc.com.nirmaan.object;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TutorialClass implements Parcelable{

    private GregorianCalendar dateTime;
    private int standard; // Class 1, Class2 and so on
    private String subject;
    private String topic;
    private int accepted; // used as a boolean
    // TODO: Add ArrayList of Question and studyMaterial object
    //      so that they can be passed with intent to start detail activity

    public TutorialClass(GregorianCalendar dateTime, int standard, String subject, String topic) {
        this.dateTime = dateTime;
        this.standard = standard;
        this.subject = subject;
        this.topic = topic;
        this.accepted = 0;
    }

    private TutorialClass(Parcel input) {
        long time = input.readLong();
        dateTime = new GregorianCalendar();
        dateTime.setTimeInMillis(time);

        standard = input.readInt();
        subject = input.readString();
        topic = input.readString();
        accepted = input.readInt();
    }


    public String getDate() {
        int dayOfMonth = dateTime.get(Calendar.DAY_OF_MONTH);
        String month = dateTime.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        int year = dateTime.get(Calendar.YEAR);
        return Integer.toString(dayOfMonth) + " " + month + ", " + Integer.toString(year);
    }

    public String getDay() {
        return dateTime.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
    }

    public String getTime() {
        int hour = dateTime.get(Calendar.HOUR);
        int minute = dateTime.get(Calendar.MINUTE);
        String amPm = dateTime.getDisplayName(Calendar.AM_PM, Calendar.LONG, Locale.getDefault());
        return Integer.toString(hour) + ":" + Integer.toString(minute) + " " + amPm;
    }

    public int getStandard() {
        return standard;
    }

    public String getSubject() {
        return subject;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        long time = dateTime.getTimeInMillis();
        dest.writeLong(time);
        dest.writeInt(standard);
        dest.writeString(subject);
        dest.writeString(topic);
        dest.writeInt(accepted);
    }

    public static final Creator<TutorialClass> CREATOR
            = new Creator<TutorialClass>() {
        @Override
        public TutorialClass createFromParcel(Parcel source) {
            return new TutorialClass(source);
        }

        @Override
        public TutorialClass[] newArray(int size) {
            return new TutorialClass[size];
        }
    };
}
