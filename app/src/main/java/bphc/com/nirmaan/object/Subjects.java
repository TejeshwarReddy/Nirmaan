package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tejeshwar on 11/3/17.
 */

public class Subjects {

    @SerializedName("subjects")
    @Expose
    private List<String> subjects = null;

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
    public Subjects(List<String> subjects) {
        super();
        this.subjects = subjects;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

}