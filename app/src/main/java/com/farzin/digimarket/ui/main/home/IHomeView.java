package com.farzin.digimarket.ui.main.home;

public interface IHomeView<T> {

    void showProgressBar();

    void hideProgressBar();

    void onSuccess(T responseMessage);

    void onError(String onError);
}
