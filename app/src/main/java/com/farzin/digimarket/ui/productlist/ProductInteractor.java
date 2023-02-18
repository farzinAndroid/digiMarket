package com.farzin.digimarket.ui.productlist;

import com.farzin.digimarket.webService.ApiCaller;
import com.farzin.digimarket.webService.IMessageListener;

public class ProductInteractor {
    private ApiCaller apiCaller;

    public ProductInteractor() {
        apiCaller = new ApiCaller();
    }

    public void getProductsByCat(int id, IMessageListener listener){
        apiCaller.getProductsByCat(id, new IMessageListener() {
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
