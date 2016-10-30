package bphc.com.nirmaan.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sarath on 30-10-2016.
 */

public class Fib implements Parcelable{

    private String question;
    private String[] answer;

    public Fib(String question, String[] answer) {
        this.question = question;
        this.answer = answer;
    }

    private Fib(Parcel parcel) {
        question = parcel.readString();
        //options = parcel.readStringArray();
        answer = parcel.readInt();
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getAnswer() {
        return answer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(question);
        parcel.writeStringArray(options);
        parcel.writeInt(answer);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<Mcq>() {
        @Override
        public Mcq createFromParcel(Parcel parcel) {
            return new Mcq(parcel);
        }

        @Override
        public Mcq[] newArray(int i) {
            return new Mcq[i];
        }

    };
}
