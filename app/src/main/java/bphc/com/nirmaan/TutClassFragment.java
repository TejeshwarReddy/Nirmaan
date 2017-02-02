package bphc.com.nirmaan;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import bphc.com.nirmaan.app.Constants;
import bphc.com.nirmaan.app.LoginPrefs;
import bphc.com.nirmaan.object.TutorialClass;
import bphc.com.nirmaan.service.BuildApi;
import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TutClassFragment extends Fragment {


    private LinearLayout mTutClassContainer;

    private List<TutorialClass> mTutorialClassList;

    public TutClassFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tut_class, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTutClassContainer = (LinearLayout) view.findViewById(R.id.tut_class_container);
        makeRequest();
        //TODO: populate views using persistent data (to be done after testing)

    }

    private void makeRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BuildApi api = retrofit.create(BuildApi.class);

        Call<List<TutorialClass>> call = api.getTutorialClasses(
                LoginPrefs.getNamePref(getActivity()), LoginPrefs.getPasswordPref(getActivity()));
        call.enqueue(new Callback<List<TutorialClass>>() {
            @Override
            public void onResponse(Call<List<TutorialClass>> call,
                                   Response<List<TutorialClass>> response) {
                mTutorialClassList = response.body();
                System.out.print("Number of classes: " + mTutorialClassList.size());

                if (mTutorialClassList.size() == 0) {
                    Toast.makeText(
                            getActivity(),
                            "You are not assigned any classes.",
                            Toast.LENGTH_SHORT).show();
                } else {

                    Realm realm = Realm.getDefaultInstance();
                    final RealmResults<TutorialClass> toBeDeleted = realm
                            .where(TutorialClass.class).findAll();

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            toBeDeleted.deleteAllFromRealm();
                            realm.copyToRealm(mTutorialClassList);
                        }
                    });

                    LayoutInflater inflater = LayoutInflater.from(getActivity());

                    for (TutorialClass tutClass : mTutorialClassList){
                        View view = inflater.inflate(R.layout.tut_class_row, mTutClassContainer);

                        TextView date = (TextView) view.findViewById(R.id.tut_class_date);
                        date.setText(tutClass.getDate());

                        TextView time_day = (TextView) view.findViewById(R.id.tut_class_accept);
                        time_day.setText(tutClass.getTime() + ", " + tutClass.getDay());

                        ImageView detail = (ImageView) view.findViewById(R.id.tut_class_detail);
                        detail.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //TODO: Complete the intent
                                Intent intent = new Intent();
                                startActivity(intent);
                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<List<TutorialClass>> call, Throwable t) {

            }
        });
    }
}
