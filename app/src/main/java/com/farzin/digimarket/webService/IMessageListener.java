package com.farzin.digimarket.webService;

public interface IMessageListener<T>{


    void onResponse(T onResponse);

    void onError(String onError);

}
