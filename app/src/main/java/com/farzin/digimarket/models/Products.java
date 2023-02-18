package com.farzin.digimarket.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Products implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;


    @SerializedName("catId")
    @Expose
    private String catId;


    @SerializedName("catName")
    @Expose
    private String catName;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("brand")
    @Expose
    private String brand;

    @SerializedName("garanti")
    @Expose
    private String garanti;

    @SerializedName("count")
    @Expose
    private String count;

    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;

    @SerializedName("fullDescription")
    @Expose
    private String fullDescription;


    @SerializedName("special")
    @Expose
    private String special;


    @SerializedName("discount")
    @Expose
    private String discount;


    @SerializedName("rate")
    @Expose
    private String rate;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("icon")
    @Expose
    private String icon;

    @SerializedName("gallery")
    @Expose
    private List<Gallery> galleries = new ArrayList<>();

    public Products() {
    }

    protected Products(Parcel in) {
        id = in.readString();
        catId = in.readString();
        catName = in.readString();
        title = in.readString();
        brand = in.readString();
        garanti = in.readString();
        count = in.readString();
        shortDescription = in.readString();
        fullDescription = in.readString();
        special = in.readString();
        discount = in.readString();
        rate = in.readString();
        price = in.readString();
        icon = in.readString();
        in.readList(galleries,Gallery.class.getClassLoader());
    }

    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGaranti() {
        return garanti;
    }

    public void setGaranti(String garanti) {
        this.garanti = garanti;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Gallery> getGalleries() {
        return galleries;
    }

    public void setGalleries(List<Gallery> galleries) {
        this.galleries = galleries;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(catId);
        parcel.writeString(catName);
        parcel.writeString(title);
        parcel.writeString(brand);
        parcel.writeString(garanti);
        parcel.writeString(count);
        parcel.writeString(shortDescription);
        parcel.writeString(fullDescription);
        parcel.writeString(special);
        parcel.writeString(discount);
        parcel.writeString(rate);
        parcel.writeString(price);
        parcel.writeString(icon);
        parcel.writeList(galleries);
    }
}
