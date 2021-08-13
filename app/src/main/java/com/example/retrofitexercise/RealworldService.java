package com.example.retrofitexercise;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RealworldService {

    @GET("/api/articles")
    Call<RealworldData> getArticle();
}
