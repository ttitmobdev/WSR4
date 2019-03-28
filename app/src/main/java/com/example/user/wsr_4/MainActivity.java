package com.example.user.wsr_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private API api;
    RecyclerView recyclerView;
    RecAdapter adapter = new RecAdapter();
    User user;
    String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rec);
        //user = new ArrayList<>();

        Intent de = getIntent();
        token = de.getStringExtra("TOKEN");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        api = ApiUtils.getApi();
        Call call = api.getUser(token);
        //loadUser(token);
    }
    public void loadUser(String token){
        Call<User> call = api.getUser(token);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user.getCount();
                user.getResults();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
