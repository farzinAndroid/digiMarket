package com.farzin.digimarket.ui.search;

import com.farzin.digimarket.ui.baseView.IView;
import com.farzin.digimarket.ui.main.home.IHomeView;
import com.farzin.digimarket.webService.IMessageListener;

import java.text.AttributedCharacterIterator;

public class SearchPresenter implements IMessageListener {

    private SearchInteractor searchInteractor;
    private IView iView;

    public SearchPresenter(SearchInteractor searchInteractor, IView iView) {
        this.searchInteractor = searchInteractor;
        this.iView = iView;
    }

    public void search(String search) {
        iView.showProgressBar();
        searchInteractor.search(search, this);
    }

    @Override
    public void onResponse(Object onResponse) {
        iView.hideProgressBar();
        iView.onSuccess(onResponse);
    }

    @Override
    public void onError(String onError) {
        iView.hideProgressBar();
        iView.onError(onError);
    }
}
