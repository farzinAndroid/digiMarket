package com.farzin.digimarket.config;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSettings {

    private SharedPreferences sh;
    private SharedPreferences.Editor editor;

    public AppSettings(Context context) {
        sh = context.getSharedPreferences("appSettings",Context.MODE_PRIVATE);
        editor = sh.edit();
    }

    //setUser Information
    public void setUserInfo(String username, int id){
        editor.putString("username",username);
        editor.putInt("id",id);
        editor.commit();
    }

    //get UserName
    public String getUserName(){
        return sh.getString("username","");
    }

    //get ID
    public int getID(){
        return sh.getInt("id",-1);
    }
}
