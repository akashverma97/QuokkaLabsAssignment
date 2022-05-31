package com.example.task1.api;

import com.example.task1.model.APIResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/entries")
    Call<APIResponseModel> fetchAPIData();
}
