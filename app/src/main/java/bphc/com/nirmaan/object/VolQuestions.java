
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;

public class VolQuestions {

    @SerializedName("mcqs")
    @Expose
    private List<VolMcq> volMcqs = null;
    @SerializedName("blanks")
    @Expose
    private RealmList<VolBlank> volBlanks = null;
    @SerializedName("truefalse")
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
    public VolQuestions(List<VolMcq> volMcqs, RealmList<VolBlank> volBlanks, RealmList<VolTruefalse> volTruefalse) {
        super();
        this.volMcqs = volMcqs;
        this.volBlanks = volBlanks;
        this.volTruefalse = volTruefalse;
    }

    public List<VolMcq> getVolMcqs() {
        return volMcqs;
    }

    public void setVolMcqs(List<VolMcq> volMcqs) {
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
