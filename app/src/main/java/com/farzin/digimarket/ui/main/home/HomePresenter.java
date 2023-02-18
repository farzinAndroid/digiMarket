package com.farzin.digimarket.ui.main.home;

import com.farzin.digimarket.webService.IMessageListener;

public class HomePresenter implements IMessageListener {

    private IHomeView iHomeView;
    private HomeInteractor interactor;
    public HomePresenter(IHomeView iHomeView, HomeInteractor interactor) {
        this.iHomeView = iHomeView;
        this.interactor = interactor;
    }


    public void getHomeWebService(){

        iHomeView.showProgressBar();
        interactor.getHomeData(this);
    }

    @Override
    public void onResponse(Object onResponse) {
        iHomeView.hideProgressBar();
        iHomeView.onSuccess(onResponse);
    }

    @Override
    public void onError(String onError) {
        iHomeView.hideProgressBar();
        iHomeView.onError(onError);
    }
}
