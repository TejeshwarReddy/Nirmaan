package bphc.com.nirmaan.database;

import android.content.Context;

import bphc.com.nirmaan.object.StuAnswerListener;
import bphc.com.nirmaan.object.StuBlank;
import bphc.com.nirmaan.object.StuMaterial;
import bphc.com.nirmaan.object.StuMcq;
import bphc.com.nirmaan.object.StuTopicCount;
import bphc.com.nirmaan.object.StuTruefalse;
import bphc.com.nirmaan.object.VolBlank;
import bphc.com.nirmaan.object.VolMcq;
import bphc.com.nirmaan.object.VolSchedule;
import bphc.com.nirmaan.object.VolTruefalse;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by tejeshwar on 2/2/17.
 */

public class DBTransactions {
    private Realm realm;

    public DBTransactions(Context context){
        Realm.init(context);
    }

    public RealmResults<VolMcq> getVolMcqs(long time){
        realm = Realm.getDefaultInstance();
        return realm.where(VolMcq.class)
                .equalTo("scheduledVisit",time)
                .findAll();
    }

    public RealmResults<VolBlank> getVolBlanks(long time){
        realm = Realm.getDefaultInstance();
        return realm.where(VolBlank.class)
                .equalTo("scheduledVisit",time)
                .findAll();
    }

    public RealmResults<VolTruefalse> getVolTrueFalse(long time){
        realm = Realm.getDefaultInstance();
        return realm.where(VolTruefalse.class)
                .equalTo("scheduledVisit",time)
                .findAll();
    }

    public RealmResults<VolSchedule> getVolSchedule(){
        realm = Realm.getDefaultInstance();
        return realm.where(VolSchedule.class)
                .findAll();
    }

    public RealmResults<StuMaterial> getMaterial(){
        realm = Realm.getDefaultInstance();
        return realm.where(StuMaterial.class)
                .distinct("subject");
    }

    public RealmResults<StuTopicCount> getTopics(String subject){
        realm = Realm.getDefaultInstance();
        return realm.where(StuTopicCount.class)
                .equalTo("subject",subject)
                .findAll();
    }

    public RealmResults<StuMcq> getStuMcqs(String subject,int topicid){
        realm = Realm.getDefaultInstance();
        return realm.where(StuMcq.class)
                .equalTo("subject",subject)
                .equalTo("topicId",topicid)
                .findAll();
    }
    public RealmResults<StuTruefalse> getStuTF(String subject, int topicid){
        realm = Realm.getDefaultInstance();
        return realm.where(StuTruefalse.class)
                .equalTo("subject",subject)
                .equalTo("topicId",topicid)
                .findAll();
    }

    public RealmResults<StuBlank> getStuBlanks(String subject, int topicid){
        realm = Realm.getDefaultInstance();
        return realm.where(StuBlank.class)
                .equalTo("subject",subject)
                .equalTo("topicId",topicid)
                .findAll();

          // TODO.equalTo("topic_id",topicid)
    }
    public void feedStudentAnswer(String answer, String subject,  int type, int topic_id, int question_id, int isRight){
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        StuAnswerListener stuAnswerListener = realm.createObject(StuAnswerListener.class);
        if (realm.where(StuAnswerListener.class)
                .equalTo("subject",subject)
                .equalTo("topic_id",topic_id)
                .equalTo("question_id",question_id)
                .equalTo("type",type)
                .findAll().size()==0) {
            stuAnswerListener.setAnswer(answer);
            stuAnswerListener.setIsRight(isRight);
            stuAnswerListener.setQuestion_id(question_id);
            stuAnswerListener.setSubject(subject);
            stuAnswerListener.setType(type);
            stuAnswerListener.setTopic_id(topic_id);

        }else{
            stuAnswerListener.setAnswer(answer);
            stuAnswerListener.setIsRight(isRight);
        }
        realm.commitTransaction();
    }

    public RealmResults<StuAnswerListener> getStudentAnswer(String subject, int topic_id, int question_id, int type){
        realm = Realm.getDefaultInstance();
        return realm.where(StuAnswerListener.class)
                .equalTo("subject",subject)
                .equalTo("topic_id",topic_id)
                .equalTo("question_id",question_id)
                .equalTo("type",type)
                .findAll();
    }
}
