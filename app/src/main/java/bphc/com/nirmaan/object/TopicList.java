package bphc.com.nirmaan.object;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tejeshwar on 11/3/17.
 */

public class TopicList {

    @SerializedName("topics")
    @Expose
    private List<Topic> topics = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public TopicList() {
    }

    /**
     *
     * @param topics
     */
    public TopicList(List<Topic> topics) {
        super();
        this.topics = topics;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

}