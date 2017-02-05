
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class StuMcq extends RealmObject{

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
    @SerializedName("subject")
    @Expose
    private String subject;

    /**
     * No args constructor for use in serialization
     * 
     */
    public StuMcq() {
    }

    /**
     * 
     * @param id
     * @param d
     * @param b
     * @param c
     * @param subject
     * @param a
     * @param topicId
     * @param question
     * @param ans
     */
    public StuMcq(String id, String topicId, String question, String a, String b, String c, String d, String ans, String subject) {
        super();
        this.id = id;
        this.topicId = topicId;
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.ans = ans;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
