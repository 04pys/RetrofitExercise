package com.example.retrofitexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        getData();

    }
    private void getData(){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://conduit.productionready.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RealworldService article = retrofit.create(RealworldService.class);

        Call<RealworldData> call = article.getArticle();

        call.enqueue(new Callback<RealworldData>() {
            @Override
            public void onResponse(Call<RealworldData> call, Response<RealworldData> response) {
                RealworldData data = response.body();
                recyclerView.setAdapter(new RecyclerViewAdapter(data.articles, MainActivity.this));

            }

            @Override
            public void onFailure(Call<RealworldData> call, Throwable t) {

            }
        });
    }

}