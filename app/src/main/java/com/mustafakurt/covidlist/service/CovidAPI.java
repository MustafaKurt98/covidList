package com.mustafakurt.covidlist.service;

import com.mustafakurt.covidlist.model.CovidModel;
import com.mustafakurt.covidlist.model.GlobalModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidAPI {

    @GET("total/dayone/country/turkey")
    Call<List<CovidModel>> getData();

    @GET("summary")
    Call<List<GlobalModel>> globalGetData();
}
