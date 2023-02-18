package com.farzin.digimarket.ui.main.category;

public interface ICategoryView<T> {

    void showProgressBar();

    void hideProgressBar();

    void onSuccess(T responseMessage);

    void onError(String error);
}
