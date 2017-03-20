package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by tejeshwar on 11/3/17.
 */

public class Topic extends RealmObject{

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("chapter_name")
    @Expose
    private String chapterName;
    @SerializedName("chapter_number")
    @Expose
    private String chapterNumber;

    /**
     * No args constructor for use in serialization
     *
     */
    public Topic() {
    }

    /**
     *
     * @param id
     * @param chapterNumber
     * @param chapterName
     */
    public Topic(String id, String chapterName, String chapterNumber) {
        super();
        this.id = id;
        this.chapterName = chapterName;
        this.chapterNumber = chapterNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(String chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

}