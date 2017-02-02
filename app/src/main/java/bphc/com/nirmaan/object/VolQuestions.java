
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class VolQuestions extends RealmObject{

    @SerializedName("volMcqs")
    @Expose
    private RealmList<VolMcq> volMcqs = null;
    @SerializedName("volBlanks")
    @Expose
    private RealmList<VolBlank> volBlanks = null;
    @SerializedName("volTruefalse")
    @Expose
    private RealmList<VolTruefalse> volTruefalse = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public VolQuestions() {
    }

    /**
     * 
     * @param volBlanks
     * @param volMcqs
     * @param volTruefalse
     */
    public VolQuestions(RealmList<VolMcq> volMcqs, RealmList<VolBlank> volBlanks, RealmList<VolTruefalse> volTruefalse) {
        super();
        this.volMcqs = volMcqs;
        this.volBlanks = volBlanks;
        this.volTruefalse = volTruefalse;
    }

    public RealmList<VolMcq> getVolMcqs() {
        return volMcqs;
    }

    public void setVolMcqs(RealmList<VolMcq> volMcqs) {
        this.volMcqs = volMcqs;
    }

    public RealmList<VolBlank> getVolBlanks() {
        return volBlanks;
    }

    public void setVolBlanks(RealmList<VolBlank> volBlanks) {
        this.volBlanks = volBlanks;
    }

    public RealmList<VolTruefalse> getVolTruefalse() {
        return volTruefalse;
    }

    public void setVolTruefalse(RealmList<VolTruefalse> volTruefalse) {
        this.volTruefalse = volTruefalse;
    }

}
