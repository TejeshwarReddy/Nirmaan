package bphc.com.nirmaan.database;

import android.content.Context;

import bphc.com.nirmaan.object.StuMaterial;
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
    public RealmResults<VolMcq> getMcqs(long time){
        realm = Realm.getDefaultInstance();
        return realm.where(VolMcq.class)
                .equalTo("scheduledVisit",time)
                .findAll();
    }

    public RealmResults<VolBlank> getBlanks(long time){
        realm = Realm.getDefaultInstance();
        return realm.where(VolBlank.class)
                .equalTo("scheduledVisit",time)
                .findAll();
    }

    public RealmResults<VolTruefalse> getTrueFalse(long time){
        realm = Realm.getDefaultInstance();
        return realm.where(VolTruefalse.class)
                .equalTo("scheduledVisit",time)
                .findAll();
    }

    public RealmResults<VolSchedule> getSchedule(){
        realm = Realm.getDefaultInstance();
        return realm.where(VolSchedule.class)
                .findAll();
    }

    public RealmResults<StuMaterial> getMaterial(){
        realm = Realm.getDefaultInstance();
        return realm.where(StuMaterial.class).distinct("subject");
    }

    /* Todo there is no topic id for each subject should figure it out*/
}
