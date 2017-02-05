package bphc.com.nirmaan.service;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import bphc.com.nirmaan.app.LoginPrefs;
import bphc.com.nirmaan.object.StuBlank;
import bphc.com.nirmaan.object.StuMaterial;
import bphc.com.nirmaan.object.StuMcq;
import bphc.com.nirmaan.object.StuQuestions;
import bphc.com.nirmaan.object.StuTruefalse;
import io.realm.Realm;
import io.realm.RealmList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedStudentDataService extends IntentService {
    public FeedStudentDataService() {
        super("FeedStudentDataService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Call<StuQuestions> studentDataCall = ApiManager.getInstance().getService().getStudentData(
                LoginPrefs.getNamePref(this),
                LoginPrefs.getPasswordPref(this));

        studentDataCall.enqueue(new Callback<StuQuestions>() {
            @Override
            public void onResponse(Call<StuQuestions> call, Response<StuQuestions> response) {
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                final RealmList<StuMcq> stuMcqs = response.body().getMcqs();
                final RealmList<StuBlank> stuBlanks = response.body().getBlanks();
                final RealmList<StuTruefalse> stuTruefalses = response.body().getTruefalse();
                final RealmList<StuMaterial> stuMaterials = response.body().getMaterial();
                if (stuMcqs.size() != 0) {
                    realm.copyToRealmOrUpdate(stuMcqs);
                }
                if (stuBlanks.size() != 0){
                    realm.copyToRealmOrUpdate(stuBlanks);
                }
                if (stuTruefalses.size() != 0){
                    realm.copyToRealmOrUpdate(stuTruefalses);
                }
                if (stuMaterials.size()!=0){
                    realm.copyToRealmOrUpdate(stuMaterials);
                }
                realm.commitTransaction();
            }

            @Override
            public void onFailure(Call<StuQuestions> call, Throwable t) {
                Toast.makeText(FeedStudentDataService.this,"Check Internet Connection",Toast.LENGTH_LONG).show();
            }
        });
    }
}
