package bphc.com.nirmaan.service;

import bphc.com.nirmaan.object.LoginSet;
import bphc.com.nirmaan.object.StudentData;
import bphc.com.nirmaan.object.VolQuestions;
import bphc.com.nirmaan.object.VolScheduleCollections;
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
    Call<VolQuestions> getUserdata(@Query("name") String name,
                                   @Query("password") String password);

    @GET("volunteer_schedule.php")
    Call<VolScheduleCollections> getScheduleSet(@Query("name") String name,
                                                @Query("password") String password);

    @GET("student_data.php")
    Call<StudentData> getStudentData(@Query("name") String name,
                                     @Query("password") String password);
}
