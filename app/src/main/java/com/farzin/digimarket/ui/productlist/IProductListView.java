package com.farzin.digimarket.ui.productlist;

public interface IProductListView<T> {

    void showProgressBar();

    void hideProgressBar();

    void onSuccess(T onSuccess);

    void onError(String error);


}
