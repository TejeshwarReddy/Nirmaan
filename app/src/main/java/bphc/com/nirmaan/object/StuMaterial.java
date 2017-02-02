
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class StuMaterial extends RealmObject{

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("chapter_number")
    @Expose
    private String chapterNumber;
    @SerializedName("chapter_name")
    @Expose
    private String chapterName;
    @SerializedName("reference")
    @Expose
    private String reference;

    /**
     * No args constructor for use in serialization
     * 
     */
    public StuMaterial() {
    }

    /**
     * 
     * @param id
     * @param chapterNumber
     * @param _class
     * @param subject
     * @param chapterName
     * @param reference
     */
    public StuMaterial(String id, String _class, String subject, String chapterNumber, String chapterName, String reference) {
        super();
        this.id = id;
        this._class = _class;
        this.subject = subject;
        this.chapterNumber = chapterNumber;
        this.chapterName = chapterName;
        this.reference = reference;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(String chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
