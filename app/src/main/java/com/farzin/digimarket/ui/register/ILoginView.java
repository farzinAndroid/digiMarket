package com.farzin.digimarket.ui.register;

public interface ILoginView {

    //View


    //MVP
    //تمام عملیاتی که در اکتیویتی یا فرگمنت انجام میشد را در فرگمنت مینویسیم


    //if userName has errors
    void onUserNameError();

    //if password has errors
    void onPasswordError();

    void onFailure();

    void onSuccess();

    void showProgressBar();

    void hideProgressBar();
}
