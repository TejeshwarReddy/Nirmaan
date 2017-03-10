package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tejeshwar on 9/3/17.
 */

public class VolunteerList {

    @SerializedName("volunteers")
    @Expose
    private List<Volunteer> volunteers = null;

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
    public VolunteerList(List<Volunteer> volunteers) {
        super();
        this.volunteers = volunteers;
    }

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(List<Volunteer> volunteers) {
        this.volunteers = volunteers;
    }


}
