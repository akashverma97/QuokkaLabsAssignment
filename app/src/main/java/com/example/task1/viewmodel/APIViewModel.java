package com.example.task1.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.task1.model.APIResponseModel;
import com.example.task1.repository.APIRepository;

public class APIViewModel extends AndroidViewModel {
    private final APIRepository repository;
    private MutableLiveData<APIResponseModel> listOfAPIs = new MutableLiveData<>();
    public APIViewModel(@NonNull Application application) {
        super(application);
        repository= new APIRepository();
    }
    private MutableLiveData<APIResponseModel> fetchAPIData(){
        return repository.fetchAPIData();
    }
    public MutableLiveData<APIResponseModel> fetchAPIDataThroughRepo(){
        listOfAPIs = fetchAPIData();
        return listOfAPIs;
    }
}

