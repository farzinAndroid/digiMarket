package com.farzin.digimarket.ui.productlist;

import com.farzin.digimarket.webService.IMessageListener;

public class ProductListPresenter implements IMessageListener {

    private IProductListView productListView;
    private ProductInteractor interactor;

    public ProductListPresenter(IProductListView productListView, ProductInteractor interactor) {
        this.productListView = productListView;
        this.interactor = interactor;
    }

    public void getProductsByCat(int id){

        productListView.showProgressBar();
        interactor.getProductsByCat(id,this);

    }


    @Override
    public void onResponse(Object onResponse) {
        productListView.hideProgressBar();
        productListView.onSuccess(onResponse);
    }

    @Override
    public void onError(String onError) {
        productListView.hideProgressBar();
        productListView.onError(onError);
    }
}
