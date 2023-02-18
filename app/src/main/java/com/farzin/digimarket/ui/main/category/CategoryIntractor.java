package com.farzin.digimarket.ui.main.category;

import com.farzin.digimarket.webService.ApiCaller;
import com.farzin.digimarket.webService.IMessageListener;

public class CategoryIntractor {

    ApiCaller apiCaller;
    public CategoryIntractor() {
        apiCaller = new ApiCaller();
    }

    public void getCategories(IMessageListener listener){

        apiCaller.getCategories(new IMessageListener() {
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
