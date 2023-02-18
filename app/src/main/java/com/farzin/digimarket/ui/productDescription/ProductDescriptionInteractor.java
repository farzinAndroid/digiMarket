package com.farzin.digimarket.ui.productDescription;

import android.content.Context;

import com.farzin.digimarket.dataBase.DigiDatabase;
import com.farzin.digimarket.models.Products;
import com.farzin.digimarket.models.ShoppingCartRoom;
import com.farzin.digimarket.webService.IMessageListener;

import java.util.List;

public class ProductDescriptionInteractor {

    public interface IRoomListener{
        void onAddedSuccessfully(int id);

        void onDeletedSuccessfully();
        void showAll(List<ShoppingCartRoom> shoppingCartRooms);

        void onError();
    }

    private DigiDatabase digiDatabase;
    private Context context;
    public ProductDescriptionInteractor(Context context) {
        this.context = context;
        digiDatabase = DigiDatabase.getInstance(context);
    }

    public void addToCart(Products products, IRoomListener listener){


        ShoppingCartRoom shoppingCartRoom = new ShoppingCartRoom();
        shoppingCartRoom.setProductID(Integer.parseInt(products.getId()));
        shoppingCartRoom.setTitle(products.getTitle());
        shoppingCartRoom.setIcon(products.getIcon());
        shoppingCartRoom.setPrice(products.getPrice());

        long insert = digiDatabase.roomDAO().insert(shoppingCartRoom);

        if (insert > 0){
            listener.onAddedSuccessfully((int) insert);
        }else {
            listener.onError();
        }

    }

    public void deleteFromCart(Products products, IRoomListener listener){

        ShoppingCartRoom shoppingCartRoom = new ShoppingCartRoom();
        shoppingCartRoom.setProductID(Integer.parseInt(products.getId()));
        shoppingCartRoom.setTitle(products.getTitle());
        shoppingCartRoom.setIcon(products.getIcon());
        shoppingCartRoom.setPrice(products.getPrice());

        digiDatabase.roomDAO().delete(shoppingCartRoom);
        listener.onDeletedSuccessfully();
    }

    public void showAll(IRoomListener listener){
        List<ShoppingCartRoom> shoppingCartRoomList = digiDatabase.roomDAO().getAllCarts();

        listener.showAll(shoppingCartRoomList);
    }
}
