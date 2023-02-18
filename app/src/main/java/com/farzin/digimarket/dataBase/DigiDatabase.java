package com.farzin.digimarket.dataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.farzin.digimarket.models.ShoppingCartRoom;
import com.farzin.digimarket.utils.Constants;

@Database(entities = {ShoppingCartRoom.class},version = 1,exportSchema = false)
public abstract class  DigiDatabase extends RoomDatabase {

    private static DigiDatabase instance = null;

    public abstract RoomDAO roomDAO();

    public static synchronized DigiDatabase getInstance(Context context){

        if (instance == null){
            instance = Room.databaseBuilder(context,DigiDatabase.class, Constants.DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
