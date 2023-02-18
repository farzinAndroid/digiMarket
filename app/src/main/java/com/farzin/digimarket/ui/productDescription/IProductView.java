package com.farzin.digimarket.ui.productDescription;

import com.farzin.digimarket.models.ShoppingCartRoom;

import java.util.List;

public interface IProductView {

    void onAddedSuccessfully(int id);

    void onDeletedSuccessfully();

    void onError();
    void showAll(List<ShoppingCartRoom> shoppingCartRooms);
}
