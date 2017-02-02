package bphc.com.nirmaan.database;

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

    public RealmResults<Mcq> getMcqs(){
        realm = Realm.getDefaultInstance();
        return realm.where(Mcq.class).findAll();
    }

    public RealmResults<Blank> getBlanks(){
        realm = Realm.getDefaultInstance();
        return realm.where(Blank.class).findAll();
    }

    public RealmResults<Truefalse> getTrueFalse(){
        realm = Realm.getDefaultInstance();
        return realm.where(Truefalse.class).findAll();
    }
}
