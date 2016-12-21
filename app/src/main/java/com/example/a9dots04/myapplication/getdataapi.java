package com.example.a9dots04.myapplication;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by 9DOTS04 on 12/20/2016.
 */

public interface getdataapi {
    @GET("/zipcodes")
    public void getforward(@Query("zipcode") String zipcode,
                           Callback<getdatalist> response);
}
