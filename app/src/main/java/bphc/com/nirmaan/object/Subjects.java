package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import io.realm.RealmObject;

/**
 * Created by tejeshwar on 11/3/17.
 */

public class Subjects extends RealmObject{

    @SerializedName("subjects")
    @Expose
    private ArrayList<String> subjects = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Subjects() {
    }

    /**
     *
     * @param subjects
     */
    public Subjects(ArrayList<String> subjects) {
        super();
        this.subjects = subjects;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }

}