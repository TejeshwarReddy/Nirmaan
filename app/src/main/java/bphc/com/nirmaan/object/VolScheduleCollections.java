package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;

/**
 * Created by tejeshwar on 2/2/17.
 */

public class VolScheduleCollections {

    @SerializedName("schedule")
    @Expose
    private RealmList<VolSchedule> volSchedule = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public VolScheduleCollections() {
    }

    /**
     *
     * @param volSchedule
     */

    public VolScheduleCollections(RealmList<VolSchedule> volSchedule) {
        super();
        this.volSchedule = volSchedule;
    }

    public RealmList<VolSchedule> getVolSchedule() {
        return volSchedule;
    }

    public void setVolSchedule(RealmList<VolSchedule> volSchedule) {
        this.volSchedule = volSchedule;
    }

}
