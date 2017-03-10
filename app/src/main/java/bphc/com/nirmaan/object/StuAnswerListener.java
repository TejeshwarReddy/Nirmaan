package bphc.com.nirmaan.object;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by tejeshwar on 5/2/17.
 */

public class StuAnswerListener extends RealmObject{

    @SerializedName("answer")
    String answer;
    @SerializedName("suject")
    String subject;
    @SerializedName("topic_id")
    int topic_id;
    @SerializedName("type")
    int type;
    @SerializedName("question_id")
    int question_id;
    @SerializedName("isRight")
    int isRight;

    public StuAnswerListener(){
        // Required default empty constructor
    }
    public StuAnswerListener(String answer, String subject, int topic_id, int type, int question_id, int isRight) {
        this.answer = answer;
        this.subject = subject;
        this.topic_id = topic_id;
        this.type = type;
        this.question_id = question_id;
        this.isRight = isRight;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getIsRight() {
        return isRight;
    }

    public void setIsRight(int isRight) {
        this.isRight = isRight;
    }

}
