package com.example.sosmobileapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = Contact.class,exportSchema = false,version = 1)
public abstract class DatabaseHelper extends RoomDatabase {

    private static final String DB_NAME= "contactsdb";
    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getDB(Context context){
        //if instance already exists dont create again return the old one
        if(instance!=null){
            return instance;
        }
        instance= Room.databaseBuilder(context,DatabaseHelper.class,DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
        return instance;
    }
    public abstract ContactDao contactDao();
}
