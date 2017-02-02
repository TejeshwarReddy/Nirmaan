package bphc.com.nirmaan.database;

import android.content.Context;

import bphc.com.nirmaan.object.Blank;
import bphc.com.nirmaan.object.Mcq;
import bphc.com.nirmaan.object.Truefalse;
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
    public RealmResults<Mcq> getMcqs(long time){
        realm = Realm.getDefaultInstance();
        return realm.where(Mcq.class)
                .equalTo("scheduledVisit",time)
                .findAll();
    }

    public RealmResults<Blank> getBlanks(long time){
        realm = Realm.getDefaultInstance();
        return realm.where(Blank.class)
                .equalTo("scheduledVisit",time)
                .findAll();
    }

    public RealmResults<Truefalse> getTrueFalse(long time){
        realm = Realm.getDefaultInstance();
        return realm.where(Truefalse.class)
                .equalTo("scheduledVisit",time)
                .findAll();
    }
}
