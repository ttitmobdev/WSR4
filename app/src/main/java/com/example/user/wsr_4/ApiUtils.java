package com.example.user.wsr_4;

public class ApiUtils {
    private static final String BASE = "http://192.168.12.68:8080/";
    private ApiUtils(){}
    public static API getApi(){
        return RetrofitClient.getRetrofit(BASE).create(API.class);
    }
}
