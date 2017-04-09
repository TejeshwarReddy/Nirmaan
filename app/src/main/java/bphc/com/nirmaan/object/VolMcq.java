
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class VolMcq extends RealmObject{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("topic_id")
    @Expose
    private String topicId;
    @PrimaryKey
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("A")
    @Expose
    private String a;
    @SerializedName("B")
    @Expose
    private String b;
    @SerializedName("C")
    @Expose
    private String c;
    @SerializedName("D")
    @Expose
    private String d;
    @SerializedName("ans")
    @Expose
    private String ans;
    @SerializedName("scheduled_visit")
    @Expose
    private Long scheduledVisit;

    /**
     * No args constructor for use in serialization
     *
     */
    public VolMcq() {
    }

    /**
     *
     * @param id
     * @param scheduledVisit
     * @param d
     * @param b
     * @param c
     * @param a
     * @param topicId
     * @param question
     * @param ans
     */
    public VolMcq(String id, String topicId, String question, String a, String b, String c, String d, String ans, Long scheduledVisit) {
        super();
        this.id = id;
        this.topicId = topicId;
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Long getScheduledVisit() {
        return scheduledVisit;
    }

    public void setScheduledVisit(Long scheduledVisit) {
        this.scheduledVisit = scheduledVisit;
    }

}