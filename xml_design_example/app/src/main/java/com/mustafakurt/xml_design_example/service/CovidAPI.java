package com.mustafakurt.xml_design_example.service;

import com.mustafakurt.xml_design_example.model.CovidModel;
import com.mustafakurt.xml_design_example.model.CountryModel;
import com.mustafakurt.xml_design_example.model.GlobalModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidAPI {

    @GET("total/dayone/country/turkey")
    Call<List<CovidModel>> getData();

    @GET("countries")
    Call<List<CountryModel>> countriesgetData();

    @GET("summary")
    Call<List<GlobalModel>> globalgetData();
}
