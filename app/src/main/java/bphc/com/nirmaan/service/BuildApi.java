package bphc.com.nirmaan.service;

import bphc.com.nirmaan.object.LoginSet;
import bphc.com.nirmaan.object.Questions;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tejeshwar on 30/9/16.
 */

public interface BuildApi {

    @GET("login.php")
    Call<LoginSet> authenticateUser(@Query("name") String name,
                                    @Query("password") String password);

    @GET("volunteer_questions.php")
    Call<Questions> getUserdata(@Query("name") String name,
                                @Query("password") String password);
}
