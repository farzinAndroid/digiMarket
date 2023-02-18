package com.farzin.digimarket.ui.baseView;

public interface IView<T> {

    void showProgressBar();

    void hideProgressBar();

    void onSuccess(T responseMessage);

    void onError(String onError);
}
