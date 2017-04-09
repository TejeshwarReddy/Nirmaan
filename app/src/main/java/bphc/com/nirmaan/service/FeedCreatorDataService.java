package bphc.com.nirmaan.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import bphc.com.nirmaan.object.CreatorData;
import bphc.com.nirmaan.object.Volunteer;
import io.realm.Realm;
import io.realm.RealmList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tejeshwar on 8/4/17.
 */

public class FeedCreatorDataService extends IntentService{

    public FeedCreatorDataService() {
        super("FeedCreatorDataService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Realm.init(this);
        Call<CreatorData> creatorDataCall = ApiManager.getInstance().getService().getAdminData("nirmaan","supersix");

        creatorDataCall.enqueue(new Callback<CreatorData>() {
            @Override
            public void onResponse(Call<CreatorData> call, Response<CreatorData> response) {
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                final RealmList<Volunteer> volunteers = response.body().getVolunteers();
                if (volunteers.size() != 0) {
                    for (int i = 0;i<volunteers.size();i++){
                        Log.e("Stumcqs",response.body().getVolunteers().get(i).getName());
                    }
                    realm.copyToRealmOrUpdate(volunteers);
                }
                realm.commitTransaction();
            }

            @Override
            public void onFailure(Call<CreatorData> call, Throwable t) {
                Toast.makeText(FeedCreatorDataService.this,"Check Internet Connection",Toast.LENGTH_LONG).show();
            }
        });
    }
}
