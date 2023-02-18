package com.farzin.digimarket.di.retrofit;

import android.app.Application;

import com.farzin.digimarket.utils.Constants;

public class MyApplication extends Application {

    ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        apiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule(Constants.BASE_URL))
                .build();
    }

    public ApiComponent getApiComponent(){
        return apiComponent;
    }
}
