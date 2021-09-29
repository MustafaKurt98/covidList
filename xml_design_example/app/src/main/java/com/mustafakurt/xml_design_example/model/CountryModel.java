package com.mustafakurt.xml_design_example.model;

import com.google.gson.annotations.SerializedName;

public class CountryModel {

    @SerializedName("Country")
    public String Countries;

    @SerializedName("Slug")
    public String Slug;

    @SerializedName("ISO2")
    public String ISO2;

}
