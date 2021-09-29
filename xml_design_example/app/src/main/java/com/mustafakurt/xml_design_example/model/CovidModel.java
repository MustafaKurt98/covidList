package com.mustafakurt.xml_design_example.model;

import com.google.gson.annotations.SerializedName;

public class CovidModel {

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
