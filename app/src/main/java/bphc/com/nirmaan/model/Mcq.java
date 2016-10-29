package bphc.com.nirmaan.model;

import android.os.Parcel;
import android.os.Parcelable;


public class Mcq implements Parcelable{

    private String question;
    private String[] options;
    private int answer;

    public Mcq(String question, String[] options, int answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    private Mcq(Parcel parcel) {
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

    public static final Creator CREATOR = new Creator<Mcq>() {
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
