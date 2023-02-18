package com.farzin.digimarket.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_cart")
public class ShoppingCartRoom {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "productId")
    private int productID;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "icon")
    private String icon;

    @ColumnInfo(name = "price")
    private String price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
