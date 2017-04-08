
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class StudentData extends RealmObject{

    @SerializedName("material")
    @Expose
    private RealmList<StuMaterial> material = null;
    @SerializedName("mcqs")
    @Expose
    private RealmList<StuMcq> mcqs = null;
    @SerializedName("truefalse")
    @Expose
    private RealmList<StuTruefalse> truefalse = null;
    @SerializedName("blanks")
    @Expose
    private RealmList<StuBlank> blanks = null;
    @SerializedName("topic_count")
    @Expose
    private RealmList<StuTopicCount> topicCount = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public StudentData() {
    }

    /**
     * 
     * @param blanks
     * @param mcqs
     * @param topicCount
     * @param truefalse
     * @param material
     */
    public StudentData(RealmList<StuMaterial> material, RealmList<StuMcq> mcqs, RealmList<StuTruefalse> truefalse, RealmList<StuBlank> blanks, RealmList<StuTopicCount> topicCount) {
        super();
        this.material = material;
        this.mcqs = mcqs;
        this.truefalse = truefalse;
        this.blanks = blanks;
        this.topicCount = topicCount;
    }

    public RealmList<StuMaterial> getMaterial() {
        return material;
    }

    public void setMaterial(RealmList<StuMaterial> material) {
        this.material = material;
    }

    public RealmList<StuMcq> getMcqs() {
        return mcqs;
    }

    public void setMcqs(RealmList<StuMcq> mcqs) {
        this.mcqs = mcqs;
    }

    public RealmList<StuTruefalse> getTruefalse() {
        return truefalse;
    }

    public void setTruefalse(RealmList<StuTruefalse> truefalse) {
        this.truefalse = truefalse;
    }

    public RealmList<StuBlank> getBlanks() {
        return blanks;
    }

    public void setBlanks(RealmList<StuBlank> blanks) {
        this.blanks = blanks;
    }

    public RealmList<StuTopicCount> getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(RealmList<StuTopicCount> topicCount) {
        this.topicCount = topicCount;
    }

}
