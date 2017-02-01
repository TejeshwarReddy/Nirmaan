
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Truefalse extends RealmObject{

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("topic_id")
    @Expose
    private String topicId;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("ans")
    @Expose
    private String ans;
    @SerializedName("scheduled_visit")
    @Expose
    private long scheduledVisit;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Truefalse() {
    }

    /**
     * 
     * @param id
     * @param scheduledVisit
     * @param topicId
     * @param question
     * @param ans
     */
    public Truefalse(String id, String topicId, String question, String ans, long scheduledVisit) {
        super();
        this.id = id;
        this.topicId = topicId;
        this.question = question;
        this.ans = ans;
        this.scheduledVisit = scheduledVisit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public long getScheduledVisit() {
        return scheduledVisit;
    }

    public void setScheduledVisit(long scheduledVisit) {
        this.scheduledVisit = scheduledVisit;
    }

}
