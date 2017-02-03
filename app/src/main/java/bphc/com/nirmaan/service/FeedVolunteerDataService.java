package bphc.com.nirmaan.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import bphc.com.nirmaan.app.LoginPrefs;
import bphc.com.nirmaan.object.VolBlank;
import bphc.com.nirmaan.object.VolMcq;
import bphc.com.nirmaan.object.VolQuestions;
import bphc.com.nirmaan.object.VolSchedule;
import bphc.com.nirmaan.object.VolScheduleCollections;
import bphc.com.nirmaan.object.VolTruefalse;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tejeshwar on 2/2/17.
 */

public class FeedVolunteerDataService extends IntentService {

    public static final String TAG = "FEED DATA SERVICE";

    public FeedVolunteerDataService() {
        super("FeedVolunteerDataService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e(TAG,TAG);
        Realm.init(this);

        Call<VolQuestions> questionsCall = ApiManager.getInstance().getService().getUserdata(LoginPrefs.getNamePref(this),LoginPrefs.getPasswordPref(this));
        questionsCall.enqueue(new Callback<VolQuestions>() {
            @Override
            public void onResponse(Call<VolQuestions> call, Response<VolQuestions> response) {
                Log.e(TAG,"success");
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                final RealmList<VolMcq> volMcqs = response.body().getVolMcqs();
                final RealmList<VolBlank> volBlanks = response.body().getVolBlanks();
                final RealmList<VolTruefalse> volTruefalses = response.body().getVolTruefalse();
                if (volMcqs.size() != 0) {
                    realm.copyToRealmOrUpdate(volMcqs);
                }
                if (volBlanks.size() != 0){
                    realm.copyToRealmOrUpdate(volBlanks);
                }
                if (volTruefalses.size() != 0){
                    realm.copyToRealmOrUpdate(volTruefalses);
                }
                realm.commitTransaction();
                RealmResults<VolMcq> mcqs1 = realm.where(VolMcq.class).findAll();
                if (mcqs1.size()!=0) {
                    for (int i = 0; i < mcqs1.size(); i++) {
                        Log.e(TAG, mcqs1.get(i).getQuestion());
                    }
                }
            }

            @Override
            public void onFailure(Call<VolQuestions> call, Throwable t) {
                Toast.makeText(FeedVolunteerDataService.this,"Check Internet Connection",Toast.LENGTH_LONG).show();
                Log.e(TAG, t.toString());
            }
        });

        Call<VolScheduleCollections> collectionsCall = ApiManager.getInstance().getService().getScheduleSet(LoginPrefs.getNamePref(this),LoginPrefs.getPasswordPref(this));
        collectionsCall.enqueue(new Callback<VolScheduleCollections>() {
            @Override
            public void onResponse(Call<VolScheduleCollections> call, Response<VolScheduleCollections> response) {
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                RealmList<VolSchedule> volSchedules = response.body().getVolSchedule();
                if (volSchedules.size()!=0){
                    realm.copyToRealmOrUpdate(volSchedules);
                }
                realm.commitTransaction();
            }

            @Override
            public void onFailure(Call<VolScheduleCollections> call, Throwable t) {
                Toast.makeText(FeedVolunteerDataService.this,"Check Internet Connection",Toast.LENGTH_LONG).show();
            }
        });

    }
}
