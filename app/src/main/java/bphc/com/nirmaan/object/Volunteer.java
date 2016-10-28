package bphc.com.nirmaan.object;


import android.os.Parcel;
import android.os.Parcelable;

public class Volunteer implements Parcelable{

    private String name;
    private String bitsId;
    private String mobileNumber;

    public Volunteer(String name, String bitsId, String mobileNumber) {
        this.name = name;
        this.bitsId = bitsId;
        this.mobileNumber = mobileNumber;
    }

    private Volunteer(Parcel input) {
        name = input.readString();
        bitsId = input.readString();
        mobileNumber = input.readString();
    }

    public String getName() {
        return name;
    }

    public String getBitsId() {
        return bitsId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(bitsId);
        dest.writeString(mobileNumber);
    }

    public static final Creator<Volunteer> CREATOR = new Creator<Volunteer>() {
        @Override
        public Volunteer createFromParcel(Parcel source) {
            return new Volunteer(source);
        }

        @Override
        public Volunteer[] newArray(int size) {
            return new Volunteer[size];
        }
    };
}
