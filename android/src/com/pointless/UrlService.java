package com.pointless;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface UrlService {
    @GET("exercises/3")
    Call<ExerciseData> getJsonData( @Query("fprmat") String sort);


    @POST("exercises/1")
    @FormUrlEncoded
    Call<Post> savePost(@Field("exercise_id") long id,
                        @Field("userId") long userId,
                        @Field("response[]") ArrayList<String> response,
                        @Field("duration") long duration,
                        @Field("completed") boolean bool,
                        @Field("correct[]") ArrayList<Boolean> correct);


}
