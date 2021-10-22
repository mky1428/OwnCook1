package com.mky1428.owncook1;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitParse {

    @GET("/api/d0dd9f7df5014307a705/COOKRCP01/json/{start}/{end}")
    Call<String> loadRecipeData(@Path("start") String start, @Path("end") String end);

}
