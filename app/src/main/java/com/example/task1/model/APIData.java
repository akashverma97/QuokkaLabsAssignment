package com.example.task1.model;

import com.google.gson.annotations.SerializedName;

public class APIData {
    @SerializedName("API")
    public String API;
    @SerializedName("Description")
    public String Description;
    @SerializedName("Auth")
    public String Auth;
    @SerializedName("Cors")
    public String Cors;
    @SerializedName("Link")
    public String Link;
    @SerializedName("Category")
    public String Category;
    @SerializedName("HTTPS")
    public boolean HTTPS;

}
