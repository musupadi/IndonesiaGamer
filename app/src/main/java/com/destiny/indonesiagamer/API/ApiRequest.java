package com.destiny.indonesiagamer.API;

import com.destiny.indonesiagamer.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiRequest {
    @FormUrlEncoded
    @POST("user/login")
    Call<ResponseModel> login(@Field("username") String username,
                              @Field("password") String password);

    @GET("game/game")
    Call<ResponseModel> Game_Limit();
}
