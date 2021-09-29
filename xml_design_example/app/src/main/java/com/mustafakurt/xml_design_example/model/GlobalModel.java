package com.mustafakurt.xml_design_example.model;

import com.google.gson.annotations.SerializedName;

public class GlobalModel {

    //        "ID": "422193c7-c13f-45f1-93dc-13ed0b281b99",
//            "Country": "Turkey",
//            "CountryCode": "TR",
//            "Slug": "turkey",
//            "NewConfirmed": 0,
//            "TotalConfirmed": 7095550,
//            "NewDeaths": 0,
//            "TotalDeaths": 63611,
//            "NewRecovered": 0,
//            "TotalRecovered": 0,
//            "Date": "2021-09-29T10:18:08.244Z",
//            "Premium": {}

    @SerializedName("Country")
    public String Country;

    @SerializedName("CountryCode")
    public String CountryCode;

    @SerializedName("TotalConfirmed")
    public String TotalConfirmed;

    @SerializedName("TotalDeaths")
    public String TotalDeaths;

    @SerializedName("Date")
    public String Date;

    @SerializedName("NewDeaths")
    public String NewDeaths;

}
