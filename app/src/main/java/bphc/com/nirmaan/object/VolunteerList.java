
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class VolunteerList extends RealmObject{

    @SerializedName("volunteers")
    @Expose
    private RealmList<Volunteer> volunteers;

    /**
     * No args constructor for use in serialization
     * 
     */
    public VolunteerList() {
    }

    /**
     * 
     * @param volunteers
     */
    public VolunteerList(RealmList<Volunteer> volunteers) {
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
