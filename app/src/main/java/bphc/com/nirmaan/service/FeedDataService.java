package bphc.com.nirmaan.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import bphc.com.nirmaan.app.LoginPrefs;
import bphc.com.nirmaan.object.Blank;
import bphc.com.nirmaan.object.Mcq;
import bphc.com.nirmaan.object.Questions;
import bphc.com.nirmaan.object.Truefalse;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tejeshwar on 2/2/17.
 */

public class FeedDataService extends IntentService {

    public static final String TAG = "FEED DATA SERVICE";

    public FeedDataService() {
        super("FeedDataService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e(TAG,TAG);
        Realm.init(this);

        Call<Questions> questionsCall = ApiManager.getInstance().getService().getUserdata(LoginPrefs.getNamePref(this),LoginPrefs.getPasswordPref(this));
        questionsCall.enqueue(new Callback<Questions>() {
            @Override
            public void onResponse(Call<Questions> call, Response<Questions> response) {
                Log.e(TAG,"success");
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                final RealmList<Mcq> mcqs = response.body().getMcqs();
                final RealmList<Blank> blanks = response.body().getBlanks();
                final RealmList<Truefalse> truefalses = response.body().getTruefalse();
                if (mcqs.size() != 0) {
                    realm.copyToRealmOrUpdate(mcqs);
                }
                if (blanks.size() != 0){
                    realm.copyToRealmOrUpdate(blanks);
                }
                if (truefalses.size() != 0){
                    realm.copyToRealmOrUpdate(truefalses);
                }
                realm.commitTransaction();
                RealmResults<Mcq> mcqs1 = realm.where(Mcq.class).findAll();
                if (mcqs1.size()!=0) {
                    for (int i = 0; i < mcqs1.size(); i++) {
                        Log.e(TAG, mcqs1.get(i).getQuestion());
                    }
                }
            }

            @Override
            public void onFailure(Call<Questions> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });


    }
}
