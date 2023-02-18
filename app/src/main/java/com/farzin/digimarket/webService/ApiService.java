package com.farzin.digimarket.webService;

import com.farzin.digimarket.models.BaseModel;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    //get Home Data
    @GET("home.php")
    Call<BaseModel> getHomeData();

    //get Categories
    @GET("getCategories.php")
    Call<BaseModel> getCategories();

    //get Login
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> login(@Field("username") String user, @Field("password") String password);

    //register
    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> register(@Field("username") String user, @Field("password") String password);

    //products by category
    @GET("getProductCategory.php")
    Call<BaseModel> getProductsByCat(@Query("catId") int id);


    //search
    @GET("search.php")
    Call<BaseModel> getSearch(@Query("title") String title);
}
