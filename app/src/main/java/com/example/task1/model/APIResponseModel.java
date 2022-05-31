package com.example.task1.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIResponseModel {
    @SerializedName("count")
    public int count;
    @SerializedName("entries")
    public List<APIData> entries = null;

}
