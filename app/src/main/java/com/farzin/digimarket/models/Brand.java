package com.farzin.digimarket.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Brand {

    @SerializedName("brand")
    @Expose
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
