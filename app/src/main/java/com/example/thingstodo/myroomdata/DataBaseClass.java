package com.example.thingstodo.myroomdata;

import android.content.Context;
import android.provider.ContactsContract;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = ModelClass.class,version = 1)
public abstract class DataBaseClass extends RoomDatabase {
    private static DataBaseClass instance;
    public abstract DAOclass daoClass();
    public static  synchronized  DataBaseClass getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), DataBaseClass.class,"Note_Data_Base").fallbackToDestructiveMigration().build();
        }
        return  instance;

    }
}
