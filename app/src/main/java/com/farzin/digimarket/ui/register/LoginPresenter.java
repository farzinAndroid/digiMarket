package com.farzin.digimarket.ui.register;

public class LoginPresenter implements LoginIntractor.ILoginListener {

    //Presenter Class

    private ILoginView iLoginView;
    private LoginIntractor intractor;

    public LoginPresenter(ILoginView iLoginView, LoginIntractor intractor) {
        this.iLoginView = iLoginView;
        this.intractor = intractor;
    }


    public void login(String userName, String password) {
        iLoginView.showProgressBar();
        intractor.login(userName, password, this);
    }

    public void register(String userName, String password) {
        iLoginView.showProgressBar();
        intractor.register(userName, password, this);
    }

    @Override
    public void onUserNameError() {
        iLoginView.hideProgressBar();
        iLoginView.onUserNameError();
    }

    @Override
    public void onPasswordError() {
        iLoginView.hideProgressBar();
        iLoginView.onPasswordError();
    }

    @Override
    public void onSuccess() {
        iLoginView.hideProgressBar();
        iLoginView.onSuccess();
    }

    @Override
    public void onError() {
        iLoginView.hideProgressBar();
        iLoginView.onFailure();
    }
}
