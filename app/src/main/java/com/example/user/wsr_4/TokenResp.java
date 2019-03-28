package com.example.user.wsr_4;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenResp {
    @SerializedName("token")
    @Expose
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
