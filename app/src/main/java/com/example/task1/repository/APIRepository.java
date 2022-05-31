package com.example.task1.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.task1.api.ApiService;
import com.example.task1.api.RetrofitService;
import com.example.task1.model.APIResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIRepository {
    private static ApiService apiService;
    private final MutableLiveData<APIResponseModel> listOfAPIs = new MutableLiveData<>();

    private static APIRepository repository;

    public static APIRepository getInstance(){
        if(repository == null){
            repository = new APIRepository();
        }
        return repository;
    }
    public APIRepository(){
        apiService = RetrofitService.getInterface();
    }

    public MutableLiveData<APIResponseModel> fetchAPIData() {
        Call<APIResponseModel> listOfMovieOut = apiService.fetchAPIData();
        listOfMovieOut.enqueue(new Callback<APIResponseModel>() {
            @Override
            public void onResponse(@NonNull Call<APIResponseModel> call, @NonNull Response<APIResponseModel> response) {
                listOfAPIs.setValue(response.body());
            }
            @Override
            public void onFailure(@NonNull Call<APIResponseModel> call, @NonNull Throwable t) {
                listOfAPIs.postValue(null);
            }
        });
        return listOfAPIs;
    }
}
