
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Visit extends RealmObject{

    @SerializedName("topic_id")
    @Expose
    private String topicId;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("chapter_name")
    @Expose
    private String chapterName;
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
     * @param _class
     * @param subject
     * @param topicId
     * @param chapterName
     * @param decision
     */
    public Visit(String topicId, String _class, String subject, String chapterName, long scheduledVisit, String decision) {
        super();
        this.topicId = topicId;
        this._class = _class;
        this.subject = subject;
        this.chapterName = chapterName;
        this.scheduledVisit = scheduledVisit;
        this.decision = decision;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
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

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
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
