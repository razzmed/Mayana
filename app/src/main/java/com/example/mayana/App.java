package com.example.mayana;

import androidx.multidex.MultiDexApplication;
import androidx.room.Room;

public class App extends MultiDexApplication {

    private NotesDatabase database;
    public static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, NotesDatabase.class, "database").allowMainThreadQueries().build();
    }

    public NotesDatabase getDatabase() {
        return database;
    }

    public static App getInstance() {
        return instance;
    }
}
