package com.farzin.digimarket.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseModel {
    //Base Class


    @SerializedName("news")
    @Expose
    private List<News> news;

    @SerializedName("mobile")
    @Expose
    private List<Products> mobile;

    @SerializedName("makeup")
    @Expose
    private List<Products> makeUp;

    @SerializedName("discount")
    @Expose
    private List<Products> discount;

    @SerializedName("AmazingOffer")
    @Expose
    private List<Products> amazingOffer;

    @SerializedName("data")
    @Expose
    private Data data;

    @SerializedName("categories")
    @Expose
    private List<Category> categories;
    @SerializedName("brands")
    @Expose
    private List<Brand> brands ;

    @SerializedName("products")
    @Expose
    private List<Products> productsList;

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<Products> getMobile() {
        return mobile;
    }

    public void setMobile(List<Products> mobile) {
        this.mobile = mobile;
    }

    public List<Products> getMakeUp() {
        return makeUp;
    }

    public void setMakeUp(List<Products> makeUp) {
        this.makeUp = makeUp;
    }

    public List<Products> getDiscount() {
        return discount;
    }

    public void setDiscount(List<Products> discount) {
        this.discount = discount;
    }

    public List<Products> getAmazingOffer() {
        return amazingOffer;
    }

    public void setAmazingOffer(List<Products> amazingOffer) {
        this.amazingOffer = amazingOffer;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}
