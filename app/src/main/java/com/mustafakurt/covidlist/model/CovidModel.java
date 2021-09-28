package com.mustafakurt.covidlist.model;

import com.google.gson.annotations.SerializedName;

public class CovidModel {
//    {
//        "Country": "Turkey",
//            "CountryCode": "",
//            "Province": "",
//            "City": "",
//            "CityCode": "",
//            "Lat": "0",
//            "Lon": "0",
//            "Confirmed": 34109,
//            "Deaths": 725,
//            "Recovered": 1582,
//            "Active": 31802,
//            "Date": "2020-04-07T00:00:00Z"
//    }




    @SerializedName("Country")
    public String Country;

    @SerializedName("Confirmed")
    public String Confirmed;

    @SerializedName("Deaths")
    public String Deaths;

    @SerializedName("Recovered")
    public String Recovered;

    @SerializedName("Active")
    public String Active;

    @SerializedName("Date")
    public String Date;


}
