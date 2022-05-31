package com.example.task1.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String BASE_URL = "https://api.publicapis.org";
    static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor()).build();
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();

    public static ApiService getInterface() {
        return retrofit.create(ApiService.class);
    }
}