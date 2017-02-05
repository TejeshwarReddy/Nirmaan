
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class CreatorData extends RealmObject{

    @SerializedName("volunteers")
    @Expose
    private RealmList<Volunteer> volunteers = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CreatorData() {
    }

    /**
     * 
     * @param volunteers
     */
    public CreatorData(RealmList<Volunteer> volunteers) {
        super();
        this.volunteers = volunteers;
    }

    public RealmList<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(RealmList<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }

}
