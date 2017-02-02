package bphc.com.nirmaan.object;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import io.realm.RealmObject;

public class TutorialClass extends RealmObject implements Parcelable{

    @SerializedName("topic_id")
    private int tutClassId;
    @SerializedName("scheduled_visit")
    private long dateTime;
    @SerializedName("class")
    private int standard; // Class 1, Class2 and so on
    private String subject;
    @SerializedName("chapter_number")
    private String chapterNumber;
    @SerializedName("chapter_name")
    private String chapterName;


    private TutorialClass(Parcel input) {
        tutClassId = input.readInt();
        dateTime = input.readLong();
        standard = input.readInt();
        subject = input.readString();
        chapterNumber = input.readString();
        chapterName = input.readString();
    }


    /**
     * @return Date as String, pattern: 8 February, 1997
     */
    public String getDate() {
        GregorianCalendar calendar = getCalendar();

        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        int year = calendar.get(Calendar.YEAR);
        return Integer.toString(dayOfMonth) + " " + month + ", " + Integer.toString(year);
    }

    /**
     * @return Day as String, pattern: Saturday
     */
    public String getDay() {
        GregorianCalendar calendar =  getCalendar();
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
    }

    /**
     * @return Time as String, pattern: 9:15 AM
     */
    public String getTime() {
        GregorianCalendar calendar = getCalendar();

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        String amPm = calendar.getDisplayName(Calendar.AM_PM, Calendar.LONG, Locale.getDefault());
        return Integer.toString(hour) + ":" + Integer.toString(minute) + " " + amPm;
    }

    private GregorianCalendar getCalendar() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(dateTime);
        return calendar;
    }

    public int getTutClassId() {
        return tutClassId;
    }

    public int getStandard() {
        return standard;
    }

    public String getSubject() {
        return subject;
    }

    public String getChapterNumber() {
        return chapterNumber;
    }

    public String getChapterName() {
        return chapterName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(tutClassId);
        dest.writeLong(dateTime);
        dest.writeInt(standard);
        dest.writeString(subject);
        dest.writeString(chapterNumber);
        dest.writeString(chapterName);
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
