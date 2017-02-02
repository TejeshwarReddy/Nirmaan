
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Questions extends RealmObject{

    @SerializedName("mcqs")
    @Expose
    private RealmList<Mcq> mcqs = null;
    @SerializedName("blanks")
    @Expose
    private RealmList<Blank> blanks = null;
    @SerializedName("truefalse")
    @Expose
    private RealmList<Truefalse> truefalse = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Questions() {
    }

    /**
     * 
     * @param blanks
     * @param mcqs
     * @param truefalse
     */
    public Questions(RealmList<Mcq> mcqs, RealmList<Blank> blanks, RealmList<Truefalse> truefalse) {
        super();
        this.mcqs = mcqs;
        this.blanks = blanks;
        this.truefalse = truefalse;
    }

    public RealmList<Mcq> getMcqs() {
        return mcqs;
    }

    public void setMcqs(RealmList<Mcq> mcqs) {
        this.mcqs = mcqs;
    }

    public RealmList<Blank> getBlanks() {
        return blanks;
    }

    public void setBlanks(RealmList<Blank> blanks) {
        this.blanks = blanks;
    }

    public RealmList<Truefalse> getTruefalse() {
        return truefalse;
    }

    public void setTruefalse(RealmList<Truefalse> truefalse) {
        this.truefalse = truefalse;
    }

}
