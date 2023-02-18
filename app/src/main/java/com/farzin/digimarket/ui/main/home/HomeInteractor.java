package com.farzin.digimarket.ui.main.home;

import com.farzin.digimarket.webService.ApiCaller;
import com.farzin.digimarket.webService.IMessageListener;

public class HomeInteractor {

    ApiCaller apiCaller;

    public HomeInteractor() {
        apiCaller = new ApiCaller();
    }


    public void getHomeData(IMessageListener listener){

        apiCaller.getHomeData(new IMessageListener() {
            @Override
            public void onResponse(Object onResponse) {
                listener.onResponse(onResponse);
            }

            @Override
            public void onError(String onError) {
                listener.onError(onError);
            }
        });
    }
}
