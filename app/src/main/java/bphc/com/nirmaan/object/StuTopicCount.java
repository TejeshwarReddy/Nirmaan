
package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class StuTopicCount extends RealmObject{

    @SerializedName("topics")
    @Expose
    private String topics;
    @PrimaryKey
    @SerializedName("subject")
    @Expose
    private String subject;

    /**
     * No args constructor for use in serialization
     * 
     */
    public StuTopicCount() {
    }

    /**
     * 
     * @param topics
     * @param subject
     */
    public StuTopicCount(String topics, String subject) {
        super();
        this.topics = topics;
        this.subject = subject;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
