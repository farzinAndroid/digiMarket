package com.farzin.digimarket.dataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.farzin.digimarket.models.ShoppingCartRoom;

import java.util.List;

@Dao
public interface RoomDAO {

    @Insert
    Long insert(ShoppingCartRoom shoppingCartRoom);

    @Delete
    void delete(ShoppingCartRoom shoppingCartRoom);

    @Query("select * from tbl_cart")
    List<ShoppingCartRoom> getAllCarts();
}
