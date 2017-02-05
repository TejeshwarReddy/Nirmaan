
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Visit extends RealmObject{

    @SerializedName("scheduled_visit")
    @Expose
    private long scheduledVisit;
    @SerializedName("decision")
    @Expose
    private String decision;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Visit() {
    }

    /**
     * 
     * @param scheduledVisit
     * @param decision
     */
    public Visit(long scheduledVisit, String decision) {
        super();
        this.scheduledVisit = scheduledVisit;
        this.decision = decision;
    }

    public long getScheduledVisit() {
        return scheduledVisit;
    }

    public void setScheduledVisit(long scheduledVisit) {
        this.scheduledVisit = scheduledVisit;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

}
