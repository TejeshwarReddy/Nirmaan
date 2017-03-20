
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Volunteer extends RealmObject{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("user_id")
    @Expose
    @PrimaryKey
    private String userId;
    @SerializedName("visits")
    @Expose
    private RealmList<Visit> visits = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Volunteer() {
    }

    /**
     * 
     * @param userId
     * @param name
     * @param visits
     */
    public Volunteer(String name, String userId, RealmList<Visit> visits) {
        super();
        this.name = name;
        this.userId = userId;
        this.visits = visits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public RealmList<Visit> getVisits() {
        return visits;
    }

    public void setVisits(RealmList<Visit> visits) {
        this.visits = visits;
    }

}
