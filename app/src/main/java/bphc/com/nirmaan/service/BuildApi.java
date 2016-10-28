package bphc.com.nirmaan.service;

import bphc.com.nirmaan.model.SignIn;
import bphc.com.nirmaan.model.SignUp;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by tejeshwar on 30/9/16.
 */

public interface BuildApi {

    @GET("test")
    Call<String> testData();

    @FormUrlEncoded
    @POST("signin")
    Call<SignIn> authenticateUser(@Field("uname") String uname,
                                  @Field("pwd") String password);

    @FormUrlEncoded
    @POST("signup")
    Call<SignUp> registerUser(@Field("uname") String uname,
                              @Field("pwd") String password,
                              @Field("utype") String utype);
}
