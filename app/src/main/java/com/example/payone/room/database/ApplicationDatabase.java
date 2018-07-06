package com.example.payone.room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.payone.room.database.dao.LeadDao;
import com.example.payone.room.database.entity.Lead;


@Database(entities = {Lead.class}, version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {

    private static final String DB_NAME = "app-database";

    private static ApplicationDatabase instance;

    public static ApplicationDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), ApplicationDatabase.class, DB_NAME).build();
        }
        return instance;
    }


    public abstract LeadDao leadDao();
}
