package com.mustafakurt.covidlist.model;

import com.google.gson.annotations.SerializedName;

public class GlobalModel {
    //    {
//        "ID": "e1428b86-43e6-45a3-81d3-9e20304e7b27",
//            "Country": "Andorra",
//            "CountryCode": "AD",
//            "Slug": "andorra",
//            "NewConfirmed": 0,
//            "TotalConfirmed": 15192,
//            "NewDeaths": 0,
//            "TotalDeaths": 130,
//            "NewRecovered": 0,
//            "TotalRecovered": 0,
//            "Date": "2021-09-29T06:11:55.27Z",
//            "Premium": {}
//    }
//    json["Global"]["NewConfirmed"],
//    json["Global"]["TotalConfirmed"],
//    json["Global"]["NewDeaths"],
//    json["Global"]["TotalDeaths"],
//    json["Global"]["NewRecovered"],
//    json["Global"]["TotalRecovered"],
//    public String
    @SerializedName("NewConfirmed")
    public String NewConfirmed;

    @SerializedName("TotalConfirmed")
    public String TotalConfirmed;

    @SerializedName("NewDeaths")
    public String NewDeaths;

    @SerializedName("TotalDeaths")
    public String TotalDeaths;

    @SerializedName("NewRecovered")
    public String NewRecovered;

    @SerializedName("TotalRecovered")
    public String TotalRecovered;


}
