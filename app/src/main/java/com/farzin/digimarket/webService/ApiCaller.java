package com.farzin.digimarket.webService;

import android.util.Log;

import com.farzin.digimarket.models.BaseModel;

import java.io.IOException;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCaller {

    ApiService apiService;

    public ApiCaller() {
        apiService = ApiClient.getClient().create(ApiService.class);
    }


    //get Home Data
    public void getHomeData(IMessageListener listener){

        Call<BaseModel> call = apiService.getHomeData();


        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                Log.e("", "");
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                Log.e("", "");
                listener.onError(t.getMessage());
            }
        });

    }


    //get Categories
    public void getCategories(IMessageListener listener){
        Call<BaseModel> call = apiService.getCategories();

        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    //get login
    public void getLogin(String user, String password, IMessageListener listener){

        Call<ResponseBody> call = apiService.login(user,password);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    listener.onResponse(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    //get register
    public void getRegister(String user, String password, IMessageListener listener){
        Call<ResponseBody> call = apiService.register(user, password);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    listener.onResponse(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    //products by category
    public void getProductsByCat(int id,IMessageListener listener){
        Call<BaseModel> call = apiService.getProductsByCat(id);

        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    //search
    public void getSearch(String title, IMessageListener listener){
        Call<BaseModel> call = apiService.getSearch(title);

        call.enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }


}
