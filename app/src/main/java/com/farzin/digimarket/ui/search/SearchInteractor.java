package com.farzin.digimarket.ui.search;

import com.farzin.digimarket.webService.ApiCaller;
import com.farzin.digimarket.webService.IMessageListener;

public class SearchInteractor {

    private ApiCaller apiCaller;


    public SearchInteractor() {
        apiCaller = new ApiCaller();
    }

    public void search(String title, IMessageListener listener){
        apiCaller.getSearch(title, new IMessageListener() {
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
