package bphc.com.nirmaan.model;

/**
 * Created by sarath on 30-10-2016.
 */

public class Fib {

    private String question;
    private String[] answers;

    public Fib(String question, String[] answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

/*
    private Fib(Parcel parcel) {
        question = parcel.readString();
        //options = parcel.readStringArray();
        answer = parcel.readIntArray();
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

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator<VolMcq>() {
        @Override
        public VolMcq createFromParcel(Parcel parcel) {
            return new VolMcq(parcel);
        }

        @Override
        public VolMcq[] newArray(int i) {
            return new VolMcq[i];
        }

    };*/

}

