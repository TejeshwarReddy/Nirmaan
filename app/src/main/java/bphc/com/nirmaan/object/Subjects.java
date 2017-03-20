package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by tejeshwar on 11/3/17.
 */

public class Subjects extends RealmObject{

    @SerializedName("subjects")
    @Expose
    private RealmList subjects = null;

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
    public Subjects(RealmList subjects) {
        super();
        this.subjects = subjects;
    }

    public RealmList getSubjects() {
        return subjects;
    }

    public void setSubjects(RealmList subjects) {
        this.subjects = subjects;
    }

}