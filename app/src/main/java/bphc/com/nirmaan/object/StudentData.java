
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;

public class StudentData {

    @SerializedName("material")
    @Expose
    private RealmList<StuMaterial> material = null;
    @SerializedName("stuMcqs")
    @Expose
    private RealmList<StuMcq> stuMcqs = null;
    @SerializedName("stuTruefalse")
    @Expose
    private RealmList<StuTruefalse> stuTruefalse = null;
    @SerializedName("stuBlanks")
    @Expose
    private RealmList<StuBlank> stuBlanks = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public StudentData() {
    }

    /**
     * 
     * @param stuBlanks
     * @param stuMcqs
     * @param stuTruefalse
     * @param material
     */
    public StudentData(RealmList<StuMaterial> material, RealmList<StuMcq> stuMcqs, RealmList<StuTruefalse> stuTruefalse, RealmList<StuBlank> stuBlanks) {
        super();
        this.material = material;
        this.stuMcqs = stuMcqs;
        this.stuTruefalse = stuTruefalse;
        this.stuBlanks = stuBlanks;
    }

    public RealmList<StuMaterial> getMaterial() {
        return material;
    }

    public void setMaterial(RealmList<StuMaterial> material) {
        this.material = material;
    }

    public RealmList<StuMcq> getStuMcqs() {
        return stuMcqs;
    }

    public void setStuMcqs(RealmList<StuMcq> stuMcqs) {
        this.stuMcqs = stuMcqs;
    }

    public RealmList<StuTruefalse> getStuTruefalse() {
        return stuTruefalse;
    }

    public void setStuTruefalse(RealmList<StuTruefalse> stuTruefalse) {
        this.stuTruefalse = stuTruefalse;
    }

    public RealmList<StuBlank> getStuBlanks() {
        return stuBlanks;
    }

    public void setStuBlanks(RealmList<StuBlank> stuBlanks) {
        this.stuBlanks = stuBlanks;
    }

}
