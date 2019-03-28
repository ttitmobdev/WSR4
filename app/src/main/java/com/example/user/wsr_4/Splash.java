package com.example.user.wsr_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;

import retrofit2.Callback;
import retrofit2.Response;

public class Splash extends AppCompatActivity {
    String user = "user";
    String password = "userQWEasd123";
    String token;

    private API api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        api = ApiUtils.getApi();
        loadtoken(user,password);
    }
    public void loadtoken(String login,String pass){
        retrofit2.Call<TokenResp> call = api.getToken(login, pass);
        call.enqueue(new Callback<TokenResp>() {
            @Override
            public void onResponse(retrofit2.Call<TokenResp> call, Response<TokenResp> response) {
                if (response.isSuccessful()){
                    token = response.body().getToken();
                    Intent go = new Intent(Splash.this,MainActivity.class);
                    go.putExtra("TOKEN",token);
                    startActivity(go);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<TokenResp> call, Throwable t) {

            }
        });
    }
}
