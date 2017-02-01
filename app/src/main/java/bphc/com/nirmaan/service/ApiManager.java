package bphc.com.nirmaan.service;

import bphc.com.nirmaan.app.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tejeshwar on 28/10/16.
 */

public class ApiManager {

    private static ApiManager instance =null;
    private BuildApi buildApi;

    private ApiManager(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        buildApi = retrofit.create(BuildApi.class);
    }

    public static ApiManager getInstance() {
        if(instance == null) {
            instance = new ApiManager();
        }
        return instance;
    }

    public BuildApi getService() {
        return buildApi;
    }
}
