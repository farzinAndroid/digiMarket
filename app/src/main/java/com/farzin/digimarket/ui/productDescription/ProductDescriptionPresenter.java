package com.farzin.digimarket.ui.productDescription;

import com.farzin.digimarket.models.Products;
import com.farzin.digimarket.models.ShoppingCartRoom;
import com.farzin.digimarket.webService.IMessageListener;

import java.util.List;

public class ProductDescriptionPresenter implements ProductDescriptionInteractor.IRoomListener {



    private IProductView iProductView;
    private ProductDescriptionInteractor productDescriptionInteractor;

    public ProductDescriptionPresenter(IProductView iProductView, ProductDescriptionInteractor productDescriptionInteractor) {
        this.iProductView = iProductView;
        this.productDescriptionInteractor = productDescriptionInteractor;
    }

    public void addToCart(Products products){

        productDescriptionInteractor.addToCart(products,this);
    }

    public void delete(Products products){
        productDescriptionInteractor.deleteFromCart(products,this);
    }

    public void showAll(){
        productDescriptionInteractor.showAll(this);
    }


    @Override
    public void onAddedSuccessfully(int id) {
        iProductView.onAddedSuccessfully(id);
    }

    @Override
    public void onDeletedSuccessfully() {
        iProductView.onDeletedSuccessfully();
    }

    @Override
    public void showAll(List<ShoppingCartRoom> shoppingCartRooms) {
        iProductView.showAll(shoppingCartRooms);
    }

    @Override
    public void onError() {

    }
}
