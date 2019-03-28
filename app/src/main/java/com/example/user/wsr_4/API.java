package com.example.user.wsr_4;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface API {

    @POST("/api-token-auth/")
    @FormUrlEncoded
    Call<TokenResp> getToken(@Field("username") String user,@Field("password") String password);

    @GET("/users/")
    Call<User> getUser(@Header("Authorization") String token);
}
